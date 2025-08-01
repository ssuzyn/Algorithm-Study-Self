import java.io.*;

public class Main {
	static final int MOD = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][][] dp = new int[N + 1][2][3]; // [날짜][지각 횟수][연속 결석 횟수]
		dp[1][0][0] = dp[1][1][0] = dp[1][0][1] = 1;

		for(int day = 2; day <= N; day++){
			dp[day][0][0] = (dp[day-1][0][0] + dp[day-1][0][1] + dp[day-1][0][2]) % MOD;
			dp[day][0][1] = dp[day-1][0][0] % MOD;
			dp[day][0][2] = dp[day-1][0][1] % MOD;
			dp[day][1][0] = (dp[day-1][0][0] + dp[day-1][0][1] + dp[day-1][0][2] + dp[day-1][1][0] + dp[day-1][1][1] + dp[day-1][1][2]) % MOD;
			dp[day][1][1] = dp[day-1][1][0] % MOD;
			dp[day][1][2] = dp[day-1][1][1] % MOD;
		}

		int answer = (dp[N][0][0] + dp[N][0][1] + dp[N][0][2] + dp[N][1][0] + dp[N][1][1] + dp[N][1][2]) % MOD;
		System.out.println(answer);
	}
}