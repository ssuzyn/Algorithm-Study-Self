import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int ans = 0;
    static char[][] map = new char[5][5];
    static int[] princess = new int[7];
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            map[i] = br.readLine().toCharArray();
        }

        pickSeven(0, 0, 0);
        System.out.println(ans);

    }

    static void pickSeven(int start, int cnt, int doyeon){
        if(doyeon > 3) return; // 이다솜파의 학생이 적어도 4명 이상 -> 임도연파 3명 초과 X

        if(cnt == 7){ // 7개의 자리를 뽑았다면 모두 인접된 자리인지 확인
            visited = new boolean[7];
            bfs();
            return;
        }

        for(int i = start; i < 25; i++){
            princess[cnt] = i;
            pickSeven(i + 1, cnt + 1, (map[i / 5][i % 5] == 'Y') ? doyeon + 1 : doyeon);
        }

    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int x = princess[0] / 5;
        int y = princess[0] % 5;

        int cnt = 1;
        visited[0] = true;
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];

            for(int i = 0; i < dx.length; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                int nxt = 5 * nx + ny;
                for(int k = 0; k < 7; k++){
                    if(!visited[k] && nxt == princess[k]){
                        visited[k] = true;
                        cnt++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if(cnt == 7) ans++;
    }
}
