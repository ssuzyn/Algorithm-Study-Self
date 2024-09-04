import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, K, ans, high;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도의 한 변 길이
            K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
            map = new int[N][N];
            visited = new boolean[N][N];
            high = 0;
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    high = Math.max(high, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == high) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false); // cut을 boolean으로 처리 (false: 아직 안깎음)
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    static void dfs(int x, int y, int depth, boolean cut) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

            if (map[x][y] > map[nx][ny]) { // 현재 봉우리 > 다음 탐색할 봉우리
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, cut);
                visited[nx][ny] = false;
            }
            
            if (map[x][y] <= map[nx][ny] && !cut) { // 아직 깎지 않은 경우에만
                for (int j = 1; j <= K; j++) {
                    if (map[nx][ny] - j < map[x][y]) { // 공사를 해서 갈 수 있는 경우
                        map[nx][ny] -= j;
                        dfs(nx, ny, depth + 1, true); // 깎은 후에는 cut=true
                        map[nx][ny] += j;
                    }
                }
            }
        }

        ans = Math.max(ans, depth); // 최댓값 갱신
    }
}
