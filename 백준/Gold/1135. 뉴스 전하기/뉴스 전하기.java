import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static List<List<Integer>> employees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		employees = new ArrayList<>();

		for(int i = 0; i < N; i++){
			employees.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i = 1; i < N; i++){
			int parent = Integer.parseInt(st.nextToken());
			employees.get(parent).add(i); // 직속 부하 저장
		}

		System.out.println(dfs(0));
	}

	/**
	 * 현재 노드에서 모든 하위 노드에 소식을 전파하는데 걸리는 최소 시간을 계산
	 * 핵심 아이디어: 시간이 오래 걸리는 부하부터 먼저 연락해야 전체 시간이 최소가 됨
	 */
	private static int dfs(int cur){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int next : employees.get(cur)){
			dp[next] = dfs(next);
			pq.add(dp[next]);
		}

		// 시간이 오래 걸리는 부하부터 먼저 연락
		int time = 0, maxTime = 0;
		while(!pq.isEmpty()){
			int depth = pq.poll();
			time++;
			maxTime = Math.max(maxTime, depth + time);
		}

		return maxTime;
	}

}