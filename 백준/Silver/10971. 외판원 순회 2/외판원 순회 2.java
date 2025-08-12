import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, minCost;
	static int[][] city;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 수
		city = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minCost = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++){
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);
		}

		System.out.println(minCost);
	}

	private static void dfs(int start, int cur, int cnt, int cost){
		if(cnt == N - 1){
			if(city[cur][start] != 0){ // 출발 도시로 돌아올 수 있는 경우에만
				minCost = Math.min(minCost, cost + city[cur][start]);
			}
			return;
		}

		if(minCost < cost) return;

		for(int i = 0; i < N; i++){
			if(city[cur][i] == 0 || visited[i]) continue;
			visited[i] = true;
			dfs(start, i, cnt + 1, cost + city[cur][i]);
			visited[i] = false;
		}
	}

}
