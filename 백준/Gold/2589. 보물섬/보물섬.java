import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int N, M, answer;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new char[N][M];
        answer = 0;

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'L') bfs(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];
            int depth = cur[2];

            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == 'L'){
                    q.add(new int[]{nx, ny, depth + 1});
                    visited[nx][ny] = true;
                    answer = Math.max(answer, depth + 1);
                }
            }
        }

    }
}