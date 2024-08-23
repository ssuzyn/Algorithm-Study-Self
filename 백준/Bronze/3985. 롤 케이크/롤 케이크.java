import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // 롤 케이크 길이
        int N = Integer.parseInt(br.readLine()); // 방청객의 수
        int[] cake = new int[L + 1]; // 1-index 케이크 배열

        int maxExpIdx = 0; // 가장 많은 조각을 받을 것으로 기대되는 방청객 번호
        int maxExp = 0; // 기대되는 최대 조각 수

        int maxActIdx = 0; // 실제로 가장 많은 조각을 받은 방청객 번호
        int[] actCnt = new int[N + 1]; // 방청객별 실제 조각 수

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int expCnt = end - start + 1; // 1. 예상되는 조각 수
            if (expCnt > maxExp) { 
                maxExp = expCnt;
                maxExpIdx = i;
            }

            
            for (int j = start; j <= end; j++) { // 케이크에 조각 할당
                if (cake[j] == 0) { // 아직 할당되지 않은 조각인 경우
                    cake[j] = i;
                    actCnt[i]++;
                }
            }
        }

        int maxAct = 0;
        for (int i = 1; i <= N; i++) { // 2. 실제로 가장 많은 케이크 조각을 받은 방청객 찾기
            if (actCnt[i] > maxAct) {
                maxAct = actCnt[i];
                maxActIdx = i;
            }
        }

        System.out.println(maxExpIdx);
        System.out.println(maxActIdx);
    }
}
