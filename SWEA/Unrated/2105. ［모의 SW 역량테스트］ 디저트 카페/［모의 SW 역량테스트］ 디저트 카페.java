import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, startX, startY, answer;
    static int[][] cafe;
    static boolean[][] visited;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static ArrayList<Integer> desert = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // test case

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cafe = new int[N][N];
            visited = new boolean[101][101];  // 디저트 종류가 1~100까지 존재

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1;
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                    desert.add(cafe[i][j]);
                    dfs(i, j, 0);
                    init();
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }

    static void init(){
        desert.clear();
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }
    }

    static void dfs(int x, int y, int direction) {
        for (int i = direction; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            // 출발점으로 돌아오고, 사각형이 최소 크기 이상인 경우
            if (nx == startX && ny == startY && desert.size() >= 3) {
                answer = Math.max(answer, desert.size());
                return;
            }

            if (!desert.contains(cafe[nx][ny]) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                desert.add(cafe[nx][ny]);
                dfs(nx, ny, i);
                visited[nx][ny] = false;
                desert.remove(Integer.valueOf(cafe[nx][ny]));
            }
        }
    }
}
