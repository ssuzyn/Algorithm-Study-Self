import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int N, M, H, tomato;
    static int[][][] box;
    static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수

        box = new int[N][M][H];
        tomato = 0;

        for(int z = 1; z <= H; z++){
            for(int x = 0; x < N; x++){
                st = new StringTokenizer(br.readLine());
                for(int y = 0; y < M; y++){
                    box[x][y][H-z] = Integer.parseInt(st.nextToken());
                    if(box[x][y][H-z] == 1) q.add(new int[]{x, y, H-z});
                    if(box[x][y][H-z] == 0) tomato++;
                }
            }
        }

        int day = 0;
        while(true){
            q = bfs();

            if(q.isEmpty()) break;
            else day++;
        }

        System.out.println(tomato == 0 ? day : -1);

    }

    private static Queue<int[]> bfs(){
        Queue<int[]> nextQ = new LinkedList<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];

            for(int i = 0; i < 6; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if(box[nx][ny][nz] == 0){
                    box[nx][ny][nz] = 1;
                    tomato--;
                    nextQ.add(new int[]{nx, ny, nz});
                }
            }
        }

        return nextQ;
    }
}