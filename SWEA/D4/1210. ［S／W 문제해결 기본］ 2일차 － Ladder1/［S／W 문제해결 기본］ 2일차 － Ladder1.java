import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 진행 방향: 좌, 우, 상
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    static final int N = 100;
    static int[][] map;
    static int x, y;

    public static void move(){
        while (x > 0) {
            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                    map[x][y] = 0;
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            sb.append("#" + br.readLine() + " ");

            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(map[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            move();
            sb.append(y).append("\n");
        }

        System.out.println(sb);

    }
}
