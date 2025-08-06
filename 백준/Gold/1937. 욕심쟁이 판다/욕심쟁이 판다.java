import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] forest;
	static int[][] dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		forest = new int[N][N];
		dp = new int[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	}

	private static int dfs(int x, int y){
		if(dp[x][y] != 0) return dp[x][y];

		dp[x][y] = 1;

		for(int[] d : dir){
			int nx = x + d[0];
			int ny = y + d[1];

			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(forest[x][y] >= forest[nx][ny]) continue;

			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
		}

		return dp[x][y];
	}

}