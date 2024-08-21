import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static long N, B, minDiff;
    static long[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine()); // N을 long 타입으로 변경
            int cnt = 0;
            
            while(N > 2) {
                long tmp = (long)Math.sqrt(N); // tmp를 long 타입으로 변경
                
                if(tmp * tmp == N) { // 제곱근이 정수라
                    N = tmp;
                    cnt++;
                }
                else { // 정수가 아니라면 현재 값의 다음 거듭제곱으로 선언
                    long next = (tmp + 1) * (tmp + 1); // next도 long 타입으로 선언
                    cnt += next - N;
                    N = next;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }

    }
}
