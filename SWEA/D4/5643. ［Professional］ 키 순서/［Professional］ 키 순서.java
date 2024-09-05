import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, ans, tCnt, sCnt;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 학생 수
            M = Integer.parseInt(br.readLine()); // 키 비교 횟수
            graph = new int[N+1][N+1];

            StringTokenizer st;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1; // from < to : 나보다 큰거 저장
            }

            ans = 0;
            for(int i = 1; i <= N; i++){
                tCnt = 0;
                sCnt = 0;
                taller(i, new boolean[N+1]);
                shorter(i, new boolean[N+1]);

                if(tCnt + sCnt == N - 1) ans++;
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    static void taller(int cur, boolean[] visited){
        visited[cur] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[cur][i] == 1){
                tCnt++;
                taller(i, visited);
            }
        }
    }

    static void shorter(int cur, boolean[] visited){
        visited[cur] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[i][cur] == 1){
                sCnt++;
                shorter(i, visited);
            }
        }
    }
}
