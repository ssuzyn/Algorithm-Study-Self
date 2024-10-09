import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new int[]{0, 0, 1, 0}); // (0, 0) 좌표에서 시작
        visited[0][0][0] = true; // 벽을 부수지 않고 시작점을 방문 처리

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            int broke = cur[3];

            if(x == N-1 && y == M-1) return depth;

            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이동할 수 있는 곳인 경우 (벽이 아님)
                if(map[nx][ny] == 0 && !visited[nx][ny][broke]){
                    visited[nx][ny][broke] = true;
                    q.add(new int[]{nx, ny, depth + 1, broke});
                }

                // 벽이 있는 경우, 벽을 부수지 않은 상태에서만 벽을 부순다
                if(broke == 0 && map[nx][ny] == 1 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true; // 벽을 부수고 방문 처리
                    q.add(new int[]{nx, ny, depth + 1, 1});
                }

            }
        }
        return -1;
    }
}
