import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] dist = new int[N][N];

            // 인접 행렬 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && dist[i][j] == 0) {
                        dist[i][j] = Integer.MAX_VALUE / 2; // 연결되지 않은 경로는 무한대 처리
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            int minCC = Integer.MAX_VALUE; // 최소 CC 값을 저장할 변수
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        sum += dist[i][j];
                    }
                }
                minCC = Math.min(minCC, sum); // 최솟값 갱신
            }

            System.out.println("#" + t + " " + minCC);
        }
    }
}
