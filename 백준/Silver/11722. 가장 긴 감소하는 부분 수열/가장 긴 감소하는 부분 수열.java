import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i = 1; i < N; i++){
            int max = 0;
            for(int j = i; j >= 0; j--){
                if(arr[i] < arr[j]){ // 현재 수보다 더 큰 수가 존재하는 경우
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);


    }

}