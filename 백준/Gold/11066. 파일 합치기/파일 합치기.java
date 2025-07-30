import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){
			int K = Integer.parseInt(br.readLine());
			int[] sum = new int[K];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++){
				if(i == 0) sum[i] = Integer.parseInt(st.nextToken());
				else sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[K][K];

			// 파일 2개부터 K개까지 점진적으로 합치기
			for(int file = 2; file <= K; file++){
				for(int start = 0; start <= K - file; start++){ // 시작점
					int end = start + file - 1;  // 끝점
					dp[start][end] = Integer.MAX_VALUE;

					for(int k = start; k < end; k++){ // 분할점 k
						int cost = (start == 0) ? sum[end] : sum[end] - sum[start-1];
						dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k+1][end] + cost);
					}
				}
			}

			System.out.println(dp[0][K-1]);
		}
	}
}