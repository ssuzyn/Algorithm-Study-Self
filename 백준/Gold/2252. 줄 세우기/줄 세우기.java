import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> answer;
	static ArrayList<Integer>[] graph;
	static int[] inDegree;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		answer = new ArrayList<>();
		graph = new ArrayList[N+1];
		inDegree = new int[N + 1]; // 각 정점의 진입 차수 저장
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			inDegree[b]++;
		}
		
		topology();
		
		for(int s : answer) {
			System.out.print(s + " ");
		}
	}
	
	private static void topology() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < inDegree.length; i++) {
			if(inDegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			answer.add(tmp);
			
			for(int i = 0; i < graph[tmp].size(); i++) {
				inDegree[graph[tmp].get(i)]--;
				
				if(inDegree[graph[tmp].get(i)] == 0)
					q.add(graph[tmp].get(i));
			}
		}
	}

}
