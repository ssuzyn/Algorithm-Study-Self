import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < line.length; i++) {
            stack.append(line[i]); // 스택처럼 사용

            if (stack.length() >= bomb.length) { // 폭탄 문자열과 길이 비교
                boolean canPop = true;
                for (int j = 0; j < bomb.length; j++) {
                    if (stack.charAt(stack.length() - bomb.length + j) != bomb[j]) {
                        canPop = false;
                        break;
                    }
                }
                if (canPop) {
                    stack.delete(stack.length() - bomb.length, stack.length()); // 폭탄 문자열 삭제
                }
            }
        }

        // 최종 출력
        if (stack.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(stack.toString());
        }
    }
}
