import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static int N;
	static int[] graph;
	static List<Integer> answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1];

		for(int i = 1; i <= N; i++){
			int num = Integer.parseInt(br.readLine());
			graph[i] = num;
		}

		visited = new boolean[N + 1];
		answer = new ArrayList<>();

		for(int i = 1; i <= N; i++){
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size() + "\n");
		for(int num : answer){
			sb.append(num + "\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int start, int target){
		if(!visited[graph[start]]){
			visited[graph[start]] = true;
			dfs(graph[start], target);
			visited[graph[start]] = false;
		}

		if(graph[start] == target) {
			answer.add(target);
			return;
		}
	}

}