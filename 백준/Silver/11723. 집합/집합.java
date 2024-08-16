import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수

        StringBuilder sb = new StringBuilder();
        int set = 0; // 비트마스크 사용

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            String op = input[0]; // 연산자

            if (input.length > 1) {
                int num = Integer.parseInt(input[1]); // 피연산자
                int bit = 1 << num; // num번째 비트를 1로 설정

                switch (op) {
                    case "add":
                        set |= bit; // num번째 비트를 1로 설정
                        break;

                    case "check":
                        sb.append((set & bit) != 0 ? 1 : 0).append("\n");
                        break;

                    case "remove":
                        set &= ~bit; // num번째 비트를 0으로 설정
                        break;

                    case "toggle":
                        set ^= bit; // num번째 비트를 토글
                        break;
                }
            } else {
                switch (op) {
                    case "all":
                        set = (1 << 21) - 1; // 모든 비트를 1로 설정 (21비트 - 1)
                        break;

                    case "empty":
                        set = 0; // 모든 비트를 0으로 설정
                        break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
