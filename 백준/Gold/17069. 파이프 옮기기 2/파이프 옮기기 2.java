
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[N][N] == 1) {
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[N + 1][N + 1][3]; // 0: 가로, 1: 세로, 2: 대각선
        dp[1][2][0] = 1; // (1, 2) 위치에 가로로 배치된 경우

        for(int i = 1; i <= N; i++) {
            for(int j = 3; j <= N; j++) {
                if(map[i][j] == 1) continue;

                // 가로 이동
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                // 세로 이동
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                // 대각선 이동
                if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        long answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(answer);
    }


}

