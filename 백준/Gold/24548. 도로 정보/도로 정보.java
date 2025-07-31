import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[][][][] dp = new int[3][3][3][3];
        dp[0][0][0][0] = 1; // 빈 구간 초기화

        int t = 0, g = 0, f = 0, p = 0, ans = 0;

        for (int i = 0; i < N; i++) {
            // 현재 문자 카운트 증가
            if (S.charAt(i) == 'T') t++;
            else if (S.charAt(i) == 'G') g++;
            else if (S.charAt(i) == 'F') f++;
            else if (S.charAt(i) == 'P') p++;

            // 같은 상태 이전 등장 횟수만큼 답에 추가
            ans += dp[t % 3][g % 3][f % 3][p % 3];

            // 현재 상태 카운트 증가
            dp[t % 3][g % 3][f % 3][p % 3]++;
        }

        System.out.println(ans);
    }
}
