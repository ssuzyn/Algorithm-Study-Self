import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 아이들 수
        int M = Integer.parseInt(st.nextToken()); // 색상의 수
        int[] color = new int[M];

        int max = 0; // 가장 많은 보석 수
        for(int i = 0; i < M; i++){
            int c = Integer.parseInt(br.readLine());
            color[i] = c;
            max = Math.max(max, c);
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;

            for(int num : color){
                cnt += num / mid;
                if(num % mid > 0) cnt++;
            }

            if(cnt <= N) {
                right = mid - 1;
                answer = mid;
            }
            else {
                left = mid + 1;
            }

        }

        System.out.println(answer);
    }
}
