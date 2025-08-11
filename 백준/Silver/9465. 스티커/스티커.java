import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];

			for(int i = 0; i < 2; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][N];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];

			for(int i = 1; i < N; i++){
				if(i == 1){
					dp[0][i] = dp[1][0] + sticker[0][i];
					dp[1][i] = dp[0][0] + sticker[1][i];
					continue;
				}
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + sticker[1][i];
			}

			sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
		}
		
		System.out.println(sb);
	}

}
