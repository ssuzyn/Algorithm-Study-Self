import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 구슬의 개수
		M = Integer.parseInt(st.nextToken()); // 구슬 쌍

		ArrayList<Integer>[] heavy = new ArrayList[N];
		ArrayList<Integer>[] light = new ArrayList[N];

		for(int i = 0; i < N; i++){
			heavy[i] = new ArrayList<>();
			light[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			// b < a
			heavy[b].add(a);
			light[a].add(b);
		}

		int count = 0;
		for(int i = 0; i < N; i++){
			int heavyCount = dfs(i, heavy, new boolean[N]);
			int lightCount = dfs(i, light, new boolean[N]);
			if(heavyCount > N / 2 || lightCount > N / 2){
				count++;
			}
		}

		System.out.println(count);
	}

	private static int dfs(int start, List<Integer>[] list, boolean[] visited){
		int result = 0;
		visited[start] = true;

		for(int num : list[start]){
			if(visited[num]) continue;
			result += 1 + dfs(num, list, visited);
		}

		return result;
	}

}
