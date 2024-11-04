import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, minLength, maxCore;
    static int[][] map;
    static List<int[]> coreInfo;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 배열의 크기
            map = new int[N][N];
            coreInfo = new ArrayList<>();
            minLength = Integer.MAX_VALUE;
            maxCore = 0;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(i > 0 && j > 0 && i < N-1 && j < N-1 && map[i][j] == 1) {
                        coreInfo.add(new int[]{i, j});
                    }
                }
            }

            connect(0, 0, 0);
            System.out.println("#" + t + " " + minLength);
        }
    }

    private static void connect(int idx, int length, int core){
        if(idx == coreInfo.size()){
            if(core > maxCore) {
                maxCore = core;
                minLength = length;
            }
            else if(core == maxCore){
                minLength = Math.min(minLength, length);
            }
            return;
        }

        int x = coreInfo.get(idx)[0];
        int y = coreInfo.get(idx)[1];

        for(int[] d : dir) {
            int nx = x; int ny = y;
            int count = 0;
            while(true){
                nx += d[0];
                ny += d[1];
                count++;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) break;

                if(nx == 0 || ny == 0 || nx == N-1 || ny == N-1){
                    nx = x; ny = y;
                    for(int i = 0; i < count; i++){
                        nx += d[0];
                        ny += d[1];
                        map[nx][ny] = 2;
                    }
                    connect(idx + 1, length + count, core + 1);

                    map[nx][ny] = 0;
                    for(int i = 0; i < count-1; i++){
                        nx -= d[0];
                        ny -= d[1];
                        map[nx][ny] = 0;
                    }
                    break;
                }
            }
        }
        connect(idx + 1, length, core);
    }
}
