import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int count;
    static int N, M, R, C, L;
    static int[][] map;

    // 방향: 상(0), 하(1), 좌(2), 우(3)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 파이프 방향 정의 (상하좌우)
    static int[][] pipe = {
        {0, 1, 2, 3}, // 1번 파이프: 상하좌우
        {0, 1},       // 2번 파이프: 상하
        {2, 3},       // 3번 파이프: 좌우
        {0, 3},       // 4번 파이프: 상우
        {1, 3},       // 5번 파이프: 하우
        {1, 2},       // 6번 파이프: 하좌
        {0, 2}        // 7번 파이프: 상좌
    };

    // 방향별 연결 가능한 파이프 번호
    static int[][] connect = {
        {1, 2, 5, 6}, // 상
        {1, 2, 4, 7}, // 하
        {1, 3, 4, 5}, // 좌
        {1, 3, 6, 7}  // 우
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 터널의 세로 크기
            M = Integer.parseInt(st.nextToken()); // 터널의 가로 크기
            R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 행 좌표
            C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 열 좌표
            L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
            map = new int[N][M];
            count = 1;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R, C);
            System.out.println("#" + t + " " + count);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, map[x][y], 1});
        map[x][y] = -1; // 방문 처리

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];
            int pipeType = cur[2];
            int time = cur[3]; // 경과된 시간

            if(time == L) continue; // 탈출 소요 시간이 된 경우 탐색 종료

            for(int d : pipe[pipeType - 1]) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nextPipeType;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || (nextPipeType = map[nx][ny]) <= 0) continue;

                if(isConnected(d, nextPipeType - 1)) {
                    q.offer(new int[] {nx, ny, nextPipeType, time + 1});
                    map[nx][ny] = -1;
                    count++;
                }
            }
        }
    }

    static boolean isConnected(int dir, int nextPipeType) {
        for(int connectPipe : connect[dir]) {
            if(connectPipe == nextPipeType + 1) {
                return true;
            }
        }
        return false;
    }
}