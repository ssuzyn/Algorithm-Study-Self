import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 1}; // 하, 우, 우하 대각선, 좌하 대각선
    static int[] dy = {0, 1, 1, 1};
    static int[][] baduk = new int[19][19];
    static List<int[]> position = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                baduk[i][j] = Integer.parseInt(st.nextToken());
                if(baduk[i][j] > 0) position.add(new int[]{i, j});
            }
        }

        for(int[] p : position){
            int x = p[0];
            int y = p[1];
            if(dfs(x, y)){
                System.out.println(baduk[x][y]);
                System.out.println((x+1) + " " + (y+1));
                return;
            }
        }
        System.out.println(0);

    }

    static boolean dfs(int x, int y){
        int color = baduk[x][y];

        for(int d = 0; d < 4; d++){
            int count = 1;

            for(int i = 1; i < 5; i++) {
                int nx = x + dx[d] * i;
                int ny = y + dy[d] * i;

                if (isNotBoundary(nx, ny) || isNotSameColor(nx, ny, color)) break;
                count++;
            }

            // 5개의 돌이 연속된 경우에만 처리
            if (count == 5) {
                // 연속된 5개 돌의 앞과 뒤에 돌이 있는지 확인
                int prevX = x - dx[d];
                int prevY = y - dy[d];
                int nextX = x + dx[d] * 5;
                int nextY = y + dy[d] * 5;

                // 6목이 아닌지 확인 (앞뒤에 돌이 있으면 안됨)
                if ((isNotBoundary(prevX, prevY) || isNotSameColor(prevX, prevY, color)) &&
                    (isNotBoundary(nextX, nextY) || isNotSameColor(nextX, nextY, color)))  {
                    return true; // 승리 조건 성립
                }
            }
        }

        return false;
    }

    static boolean isNotBoundary(int x, int y){
        return x < 0 || y < 0 || x >= 19 || y >= 19;
    }

    static boolean isNotSameColor(int x, int y, int color){
        return baduk[x][y] != color;
    }

}
