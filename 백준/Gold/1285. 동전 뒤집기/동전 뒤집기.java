import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                coin[i] = coin[i] << 1;
                if (input[j] == 'T') // 뒷면인 경우 1을 더함
                {
                    coin[i] = coin[i] | 1;
                }
            }
        }

        answer = Integer.MAX_VALUE;
        reverseHang(0);
        System.out.println(answer);
    }

    private static void reverseHang(int idx) {
        if (idx == N) { // 행 뒤집기 탐색이 끝난 경우
            int sum = 0;
            for (int i = 0; i < N; i++) { // 열

                int cnt = 0; // 뒷면(T)의 갯수
                for (int j = 0; j < N; j++) { // 현재 열의 각 행 확인
                    if (((coin[j] & (1 << N - i - 1))) != 0) {
                        cnt++;
                    }
                }

                sum += Math.min(cnt, N - cnt);
            }
            answer = Math.min(answer, sum);
            return;
        }

        coin[idx] = ~coin[idx]; // idx행 뒤집기
        reverseHang(idx + 1);
        coin[idx] = ~coin[idx]; // 뒤집은 idx행 원상 복구
        reverseHang(idx + 1);
    }
}