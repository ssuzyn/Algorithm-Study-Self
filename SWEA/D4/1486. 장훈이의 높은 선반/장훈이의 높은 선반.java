import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, B, minDiff;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 점원 수
            B = Integer.parseInt(st.nextToken()); // 선반의 높이
            height = new int[N]; // 직원 키
            minDiff = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0);

            System.out.println("#" + tc + " " + minDiff);
        }

    }

    private static void solve(int cnt, int sum){
    	if(sum >= B){
            minDiff = Math.min(minDiff, sum - B);
            return;
        }
        
        if(cnt == N) {
        	return;
        }

        solve(cnt + 1, sum + height[cnt]);
        solve(cnt + 1, sum);
    }
}
