import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, min;
    static int[][] map;
    static boolean[] selected;
    static List<int[]> core;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            core = new ArrayList<>(); // 코어 위치 저장하는 리스트
            min = Integer.MAX_VALUE;

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 가장자리가 아닌 코어만 리스트에 추가
                    if(map[i][j] == 1 && i > 0 && i < N-1 && j > 0 && j < N-1) {
                        core.add(new int[]{i, j});
                    }
                }
            }

            selected = new boolean[core.size()];
            for(int i = core.size(); i >= 0; i--){
                combination(0, 0, i);
                if(min < Integer.MAX_VALUE) break;
            }

            System.out.println("#" + t + " " + min);
        }
    }

    static void combination(int cnt, int start, int pick){
        if(cnt == pick){
            dfs(0, 0);
            return;
        }

        for(int i = start; i < core.size(); i++){
            selected[i] = true;
            combination(cnt + 1, i + 1, pick);
            selected[i] = false;
        }
    }

    static void dfs(int idx, int wire){
        if(idx == core.size()) {
            min = Math.min(min, wire); // 최소 전선 길이 합으로 갱신
            return;
        }

        if(!selected[idx]) { // 부분 집합에 포함되지 않는 코어는 넘어감
            dfs(idx + 1, wire);
            return;
        }

        for(int i = 0; i < 4; i++){
            int x = core.get(idx)[0];
            int y = core.get(idx)[1];
            int length = 0;
            boolean success = false;

            while(true){
                x += dx[i]; y += dy[i];
                if(x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝에 도착했으면 성공
                    success = true;
                    break;
                }
                if(map[x][y] != 0) break; // 전선이나 코어를 만나면 실패
                map[x][y] = 2; // 전선
                length++;
            }

            if(success) dfs(idx + 1, wire + length);

            while(true){ // 원상복구
                x -= dx[i]; y -= dy[i];
                if(x == core.get(idx)[0] && y == core.get(idx)[1]) break;
                map[x][y] = 0;
            }
        }
    }


}