import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static List<Integer>[] graph;
	public static boolean[] visited;
	public static int count = 0;
	
	public static void getJobCount(int X) {
		visited[X] = true;
		
		for(int next: graph[X]) {
			if(!visited[next]) {
				count++;
				getJobCount(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph[i] = new LinkedList<>();
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n2].add(n1);
		}
		
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		
		getJobCount(X);
		
		System.out.println(count);
	}
}
