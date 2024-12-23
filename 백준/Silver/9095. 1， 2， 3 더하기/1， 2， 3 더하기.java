import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                if (i == 1) dp[i] = 1;
                else if (i == 2) dp[i] = 2;
                else if (i == 3) dp[i] = 4;
                else dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[N] + "\n");
        }
        System.out.println(sb);
    }
}