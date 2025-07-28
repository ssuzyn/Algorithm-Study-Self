import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 2]; // 상담을 완료하는데 걸리는 기간
		int[] P = new int[N + 2]; // 상담 금액
		int[] dp = new int[N + 2];

		StringTokenizer st;
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int max = -1;
		for(int day = 1; day <= N + 1; day++){
			if(max < dp[day]) max = dp[day];

			int endDate = day + T[day];
			if(endDate <= N + 1){
				dp[endDate] = Math.max(dp[endDate], max + P[day]);
			}
		}

		System.out.println(dp[N + 1]);
	}

}