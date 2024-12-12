import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 구간 갯수
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max - min;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int curMin = arr[0];
            int curMax = arr[0];
            int cut = 1;

            for(int i = 1; i < N; i++){
                curMin = Math.min(curMin, arr[i]);
                curMax = Math.max(curMax, arr[i]);

                if(curMax - curMin > mid){
                    cut++;
                    // 새로운 구간 최소값, 최대값 갱신
                    curMin = arr[i];
                    curMax = arr[i];
                }
            }

            if(cut <= M) { // M개 이하로 나눌 수 있다
                answer = mid;
                right = mid - 1; // 더 작은 값도 가능한지
            }
            else{
                left = mid + 1; // 더 큰 값 필요
            }
        }

        System.out.println(answer);
    }
}
