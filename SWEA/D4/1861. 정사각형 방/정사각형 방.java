import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxRoom = Integer.MIN_VALUE;
            int index = -1;
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int result = dfs(i, j);
                    if(result > maxRoom){
                        maxRoom = result;
                        index = map[i][j];
                    } else if(result == maxRoom && map[i][j] < index) {
                        index = map[i][j];
                    }
                }
            }

            System.out.println("#" + t + " " + index + " " + maxRoom);
        }
    }

    private static int dfs(int x, int y) {
        int depth = 1;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(map[nx][ny] - map[x][y] == 1) {
                depth = Math.max(depth, 1 + dfs(nx, ny));
            }
        }

        return depth;
    }

}
