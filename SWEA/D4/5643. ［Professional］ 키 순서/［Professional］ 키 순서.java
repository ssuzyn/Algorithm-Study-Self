import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            
            for(int i = 1; i <= N; i++) {
            	Arrays.fill(graph[i], Integer.MAX_VALUE/2);
            }
            

            StringTokenizer st;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1; // from < to : 나보다 큰거 저장
            }

            
            for(int k = 1; k <= N; k++) {
            	for(int i = 1; i <= N; i++) {
            		for(int j = 1; j <= N; j++) {
            			graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
            		}
            	}
            }
            
            ans = 0; // 자신의 키 순서를 알 수 있는 학생 수
            for (int i = 1; i <= N; i++) {
                int greaterCount = 0; // 나보다 큰 학생 수
                int smallerCount = 0; // 나보다 작은 학생 수

                // 나보다 큰 학생과 작은 학생을 계산
                for (int j = 1; j <= N; j++) {
                    if (i != j) {
                        if (graph[i][j] < Integer.MAX_VALUE / 2) {
                            greaterCount++; // i보다 큰 j 학생
                        }
                        if (graph[j][i] < Integer.MAX_VALUE / 2) {
                            smallerCount++; // j보다 큰 i 학생
                        }
                    }
                }

                // 자신보다 큰 학생과 작은 학생의 수가 총 N-1명인 경우
                if (greaterCount + smallerCount == N - 1) {
                    ans++;
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

}
