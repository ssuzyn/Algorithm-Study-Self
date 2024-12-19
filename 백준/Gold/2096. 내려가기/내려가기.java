import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M = 3;
    static int[][] map;
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][M];

        int[][] minD = new int[N][M];
        int[][] maxD = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(minD[i], Integer.MAX_VALUE);
            Arrays.fill(maxD[i], Integer.MIN_VALUE);
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0){
                    minD[i][j] = map[i][j];
                    maxD[i][j] = map[i][j];
                }
            }
        }

        for(int x = 1; x < N; x++){
            for(int y = 0; y < M; y++){
                for(int i = 0; i < 3; i++){
                    int ny = y + dy[i];
                    if(ny < 0 || ny >= M) continue;

                    minD[x][y] = Math.min(minD[x][y], minD[x-1][ny] + map[x][y]);
                    maxD[x][y] = Math.max(maxD[x][y], maxD[x-1][ny] + map[x][y]);
                }
            }
        }

        System.out.println(Math.max(Math.max(maxD[N-1][0], maxD[N-1][1]), maxD[N-1][2])
            + " " + Math.min(Math.min(minD[N-1][0], minD[N-1][1]), minD[N-1][2]));
    }

}
