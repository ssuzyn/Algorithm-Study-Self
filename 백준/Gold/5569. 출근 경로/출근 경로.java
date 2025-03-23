import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int mod = 100000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); // 열
		int H = Integer.parseInt(st.nextToken()); // 행

		// dp[i][j][k][l]
		// i, j: 현재 위치 (i행, j열)
		// k: 현재 방향 (0: 동쪽으로 이동 중, 1: 남쪽으로 이동 중)
		// l: 방향 전환 여부 (0: 꺾지 않음/직진, 1: 방향을 꺾음)
		int[][][][] dp = new int[H+1][W+1][2][2];

		for(int i = 1; i <= W; i++){
			dp[1][i][0][0] = 1;
		}
		for(int i = 1; i <= H; i++){
			dp[i][1][1][0] = 1;
		}

		for(int i = 2; i <= H; i++){
			for(int j = 2; j <= W; j++){
				// 오른쪽 방향
				dp[i][j][0][0] = (dp[i][j-1][0][0] + dp[i][j-1][0][1]) % mod;
				dp[i][j][0][1] = dp[i][j-1][1][0] % mod;
				// 아래쪽 방향
				dp[i][j][1][0] = (dp[i-1][j][1][0] + dp[i-1][j][1][1]) % mod;
				dp[i][j][1][1] = dp[i-1][j][0][0] % mod;
			}
		}

		int answer = (dp[H][W][0][0] + dp[H][W][0][1] + dp[H][W][1][0] + dp[H][W][1][1]) % mod;
		System.out.println(answer);
	}

}
