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
	static int[] inDegree;
	static List<List<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가수의 수
		M = Integer.parseInt(st.nextToken()); // 보조 PD

		inDegree = new int[N + 1];
		for(int i = 0; i <= N; i++){
			graph.add(new ArrayList<>());
		}

		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());  // 첫 번째 가수
			for(int i = 1; i < cnt; i++) {  // 나머지 가수들과 연결
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				inDegree[b]++;
				a = b;
			}
		}

		topology();
	}

	private static void topology(){
		Queue<Integer> q = new LinkedList<>();

		for(int i = 1; i <= N; i++){
			if(inDegree[i] == 0) q.add(i);
		}

		while(!q.isEmpty()){
			int tmp = q.poll();
			sb.append(tmp).append("\n");
			N--;

			for(int next : graph.get(tmp)){
				inDegree[next]--;
				if(inDegree[next] == 0) q.add(next);
			}
		}

		if(N == 0) System.out.println(sb);
		else System.out.println(0);
	}

}