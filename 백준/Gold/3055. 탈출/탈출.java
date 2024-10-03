import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> hedgehogQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        map = new char[R][C];
        visited = new boolean[R][C];  // 방문 체크 배열

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'S') {
                    hedgehogQ.add(new int[]{i, j, 0});
                    visited[i][j] = true;  // 고슴도치의 초기 위치 방문 처리
                }
                if(map[i][j] == '*') waterQ.add(new int[]{i, j});
            }
        }

        int answer = bfs();
        if(answer == -1) System.out.println("KAKTUS");
        else System.out.println(answer);

    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static void flood(){
        int size = waterQ.size();

        for(int s = 0; s < size; s++){
            int[] cur = waterQ.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isValid(nx, ny) || map[nx][ny] == 'D' ||
                    map[nx][ny] == '*' || map[nx][ny] == 'X') continue;

                map[nx][ny] = '*';
                waterQ.add(new int[]{nx, ny});
            }
        }
    }

    private static int bfs(){
        while(!hedgehogQ.isEmpty()){

            // 1. 물 확장
            flood();

            // 2. 고슴도치 이동
            int size = hedgehogQ.size();

            for(int s = 0; s < size; s++){
                int[] cur = hedgehogQ.poll();
                int x = cur[0];
                int y = cur[1];
                int depth = cur[2];

                if(map[x][y] == 'D') return depth;  // 비버 굴에 도착하면 종료

                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(!isValid(nx, ny) || visited[nx][ny] ||
                        map[nx][ny] == '*' || map[nx][ny] == 'X') continue;

                    hedgehogQ.add(new int[]{nx, ny, depth + 1});
                    visited[nx][ny] = true;  // 방문 처리
                }
            }
        }

        return -1;
    }
}
