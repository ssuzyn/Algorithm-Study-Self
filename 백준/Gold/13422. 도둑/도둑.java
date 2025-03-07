import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 집의 개수
            int M = Integer.parseInt(st.nextToken()); // 돈 훔칠 연속된 집의 개수
            int K = Integer.parseInt(st.nextToken()); // 자동 방범 장치가 작동하는 최소 돈의 양
            int[] home = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                home[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = M - 1;
            int sum = 0;
            for(int i = 0; i <= end; i++){
                sum += home[i];
            }

            if(N == M && sum < K) {
                sb.append(1).append("\n");
                continue;
            }

            int count = 0;
            
            do {
                if (sum < K) count++;

                sum -= home[start];
                start = (start + 1) % N;
                end = (end + 1) % N;
                sum += home[end];
            } while (start != 0);

            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }
}