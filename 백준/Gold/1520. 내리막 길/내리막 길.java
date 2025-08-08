import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M];
		dp = new int[N][M];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y){
		if(dp[x][y] != -1) return dp[x][y];

		if(x == N-1 && y == M-1) return 1;

		// 현재 위치에서 갈 수 있는 모든 방향 탐색
		dp[x][y] = 0;
		for(int[] d : dir){
			int nx = x + d[0];
			int ny = y + d[1];

			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(map[x][y] > map[nx][ny]) dp[x][y] += dfs(nx, ny);
		}

		return dp[x][y];
	}

}