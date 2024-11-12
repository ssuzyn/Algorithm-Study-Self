import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] inDegree;
	static List<Integer>[] problem;
	static List<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 문제의 수 
		M = Integer.parseInt(st.nextToken()); // 문제 정보의 개수 
		inDegree = new int[N + 1];
		problem = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			problem[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			problem[a].add(b); // A번 문제 < B번 문제
			inDegree[b]++;
		}
		
		answer = new ArrayList<>();
		topology();
		for(int n : answer) {
			System.out.print(n + " ");
		}
	}
	
	private static void topology() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			answer.add(cur);
			
			for(int next : problem[cur]) {
				inDegree[next]--;
				if(inDegree[next] == 0) q.add(next);
			}
		}
	}
	
}
