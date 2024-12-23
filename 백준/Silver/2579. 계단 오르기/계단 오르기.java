import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] s = new int[N + 1];

        for(int i = 1; i <= N; i++){
            s[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = s[1];
        if(N >= 2) dp[2] = s[1] + s[2];
        for(int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-3] + s[i-1], dp[i-2]) + s[i];
        }
        System.out.println(dp[N]);
    }
}