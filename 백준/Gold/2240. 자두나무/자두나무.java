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

		for(int t = 1; t <= T; t++){
			plum[t] = Integer.parseInt(br.readLine());

			for(int w = 1; w <= W + 1; w++){
				if(plum[t] == 1){
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]) + 1;
					dp[2][t][w] = Math.max(dp[2][t-1][w], dp[1][t-1][w-1]);
				}
				else{
					if(t == 1 && w == 1) continue;
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]);
					dp[2][t][w] = Math.max(dp[2][t-1][w], dp[1][t-1][w-1]) + 1;
				}
			}
		}

		int result = 0;
		for(int w = 1; w <= W + 1; w++){
			result = Math.max(result, Math.max(dp[1][T][w], dp[2][T][w]));
		}

		System.out.println(result);
	}
}