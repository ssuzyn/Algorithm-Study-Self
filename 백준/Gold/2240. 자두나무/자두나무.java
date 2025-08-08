import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] plum = new int[T + 1];
		int[][][] dp = new int[3][T + 1][W + 2];

		for(int i = 1; i <= T; i++){
			plum[i] = Integer.parseInt(br.readLine());
		}

		for(int t = 1; t <= T; t++){
			for(int w = 1; w <= W + 1; w++){
				if(plum[t] == 1){ // 1번 나무에 있는 경우
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]) + 1;
					dp[2][t][w] = Math.max(dp[2][t-1][w], dp[1][t-1][w-1]);
				}
				else{ // 2번 나무에 있는 경우
					if(t == 1 && w == 1) continue; // 자두는 처음에 1번 나무에 있으므로 1초에 2번 나무로 갈 수 없음
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]);
					dp[2][t][w] = Math.max(dp[2][t-1][w], dp[1][t-1][w-1]) + 1;
				}
			}
		}

		// T초에 1번 또는 2번 나무에서 가능한 모든 이동횟수 중 최대값
		int result = 0;
		for(int w = 1; w <= W + 1; w++){
			result = Math.max(result, Math.max(dp[1][T][w], dp[2][T][w]));
		}

		System.out.println(result);
	}

}