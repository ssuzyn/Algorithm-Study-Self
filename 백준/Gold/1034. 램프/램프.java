import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        HashMap<String, Integer> map = new HashMap<>();
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                // 0의 개수를 카운트
                if (input[i].charAt(j) == '0') count++;
            }

            if (count <= K && count % 2 == K % 2) {
                map.put(input[i], map.getOrDefault(input[i], 0) + 1);
                if (map.get(input[i]) > answer) {
                    answer = map.get(input[i]);
                }
            }
        }

        System.out.println(answer);
    }
}