import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0}; // 하 -> 우 -> 상 -> 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행 크기
        M = Integer.parseInt(st.nextToken()); // 열 크기
        R = Integer.parseInt(st.nextToken()); // 회전의 수
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < Math.min(N, M) / 2; j++) {
                rotation(j, j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotation(int startX, int startY) {
        int x = startX;
        int y = startY;
        int curValue = map[x][y];
        int idx = 0;

        while (idx < 4) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx < startX || ny < startY || nx >= N - startX || ny >= M - startY) {
                idx++;
            } else {
                int tmp = map[nx][ny]; // 다음 위치 임시 저장
                map[nx][ny] = curValue; // 현재 값을 다음 위치로 이동
                curValue = tmp;
                x = nx;
                y = ny;
            }

        }
    }
}
