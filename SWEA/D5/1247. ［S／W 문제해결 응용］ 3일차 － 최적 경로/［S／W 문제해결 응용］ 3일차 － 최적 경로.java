import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, minDistance;
    static int[][] position;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 고객의 수
            position = new int[N+2][2];
            visited = new boolean[N+2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N+2; i++) {
                position[i][0] = Integer.parseInt(st.nextToken());
                position[i][1] = Integer.parseInt(st.nextToken());
            }

            minDistance = Integer.MAX_VALUE;
            dfs(0, 0, 0); // 회사에서 출발, depth 1부터 시작

            System.out.println("#" + t + " " + minDistance);
        }
    }

    public static void dfs(int cur, int depth, int sum) {
        if(sum > minDistance) return;

        if(depth == N) {
            sum += Math.abs(position[cur][0] - position[1][0]) + Math.abs(position[cur][1] - position[1][1]);
            minDistance = Math.min(sum, minDistance);
            return;
        }

        for(int i = 2; i < N + 2; i++) { // 2번부터 N+1번까지 고객
            if(visited[i]) continue;

            visited[i] = true;

            int nextDistance = sum + Math.abs(position[cur][0] - position[i][0])
                +  Math.abs(position[cur][1] - position[i][1]);
            dfs(i, depth + 1, nextDistance);
            visited[i] = false;
        }
    }

}
