import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        map = new int[M][N];
        dp = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y){
        if(x == M-1 && y == N-1) return 1;

        if(dp[x][y] == -1){
            dp[x][y] = 0;

            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[x][y] > map[nx][ny]) { // 내리막길인 경우
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
    
}