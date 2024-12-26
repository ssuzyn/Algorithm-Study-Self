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

        for(int i = 1; i <= N; i++){
            if(i + T[i] <= N + 1){
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]); // i일에 상담 하는 경우
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // i일에 상담하지 않는 경우
        }

        System.out.println(dp[N + 1]);
    }

}