import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우로 이동하는 방향
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1}; // 말처럼 이동하는 방향
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] world;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 최대 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        world = new int[H][W]; // 세로(H) x 가로(W)
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0}); // 시작점 (x, y, 사용한 말 찬스 수, 이동 횟수)
        boolean[][][] check = new boolean[H][W][K + 1];  // 세로(H) x 가로(W) x 말 찬스

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int chance = cur[2];
            int move = cur[3];

            if (x == H - 1 && y == W - 1) return move; // 목적지 도착

            int nx, ny;

            // 원숭이 4가지 방향 탐색 (상하좌우)
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || world[nx][ny] == 1) continue;
                if (check[nx][ny][chance]) continue; // 이미 방문한 상태인지 확인

                check[nx][ny][chance] = true;
                q.offer(new int[]{nx, ny, chance, move + 1});
            }

            // 기회가 남아있다면, 말 8가지 방향 탐색
            if (chance < K) {
                for (int i = 0; i < 8; i++) {
                    nx = x + hx[i];
                    ny = y + hy[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W || world[nx][ny] == 1) continue;
                    if (check[nx][ny][chance + 1]) continue; // 말처럼 이동한 찬스를 사용한 적이 있는지 확인

                    check[nx][ny][chance + 1] = true;
                    q.offer(new int[]{nx, ny, chance + 1, move + 1});
                }
            }
        }

        return -1;
    }
}