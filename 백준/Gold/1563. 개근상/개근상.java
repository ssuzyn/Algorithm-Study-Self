import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][][] dp;
	static final int MOD = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][2][3]; // [날짜][지각 횟수][연속 결석 횟수]

		for(int i = 0; i <= N; i++){
			for(int j = 0; j < 2; j++){
				Arrays.fill(dp[i][j], -1);
			}
		}

		System.out.println(solve(0 ,0, 0));
	}

	private static int solve(int day, int late, int absent){
		if(late == 2 || absent == 3) return 0;
		if(day == N) return 1;

		if(dp[day][late][absent] != -1) return dp[day][late][absent];

		dp[day][late][absent] = 0;
		dp[day][late][absent] = solve(day + 1, late, 0)
								+ solve(day + 1, late + 1, 0)
								+ solve(day + 1, late, absent + 1);

		return dp[day][late][absent] % MOD;
	}
}