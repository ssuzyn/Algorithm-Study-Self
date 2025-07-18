import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] height;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
		height = new ArrayList[N + 1];
		inDegree = new int[N + 1];

		for(int i = 1; i <= N; i++){
			height[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			height[A].add(B); // A < B
			inDegree[B]++;
		}

		topology();
	}

	private static void topology(){
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= N; i++){
			if(inDegree[i] == 0) q.add(i);
		}

		while(!q.isEmpty()){
			int cur = q.poll();
			sb.append(cur).append(" ");

			for(int num : height[cur]){
				inDegree[num]--;
				if(inDegree[num] == 0) q.add(num);
			}
		}

		System.out.println(sb);
	}
}