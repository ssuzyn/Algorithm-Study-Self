import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[][] tree;
    static boolean[][] visited;
    static int[][] dx = {{1, 0}, {-1, 0}, {-1, 0}, {1, 0}};
    static int[][] dy = {{0, -1}, {0, -1}, {0, 1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        max = Integer.MIN_VALUE;

        tree = new int[N][M];
        visited = new boolean[N][M];

        if(N < 2 && M < 2){ // 부메랑을 만들 수 없는 경우
            System.out.println(0);
            return;
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        System.out.println(max);

    }

    private static boolean isValid(int x1, int y1, int x2, int y2) {
        if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) return false;
        if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) return false;
        if(visited[x1][y1] || visited[x2][y2]) return false;
        return true;
    }

    private static void solve(int idx, int power){
        if(idx == N * M){
            max = Math.max(power, max);
            return;
        }

        int x = idx / M;
        int y = idx % M;

        if(!visited[x][y]){
            for(int i = 0; i < 4; i++) {
                int nx1 = x + dx[i][0];
                int ny1 = y + dx[i][1];
                int nx2 = x + dy[i][0];
                int ny2 = y + dy[i][1];

                if(isValid(nx1, ny1, nx2, ny2)) {
                    visited[x][y] = true;
                    visited[nx1][ny1] = true;
                    visited[nx2][ny2] = true;

                    solve(idx + 1, power + tree[x][y] * 2 + tree[nx1][ny1] + tree[nx2][ny2]);

                    visited[x][y] = false;
                    visited[nx1][ny1] = false;
                    visited[nx2][ny2] = false;
                }

            }
        }

        solve(idx + 1, power);

    }
}
