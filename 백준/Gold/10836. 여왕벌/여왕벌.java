import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 격자칸의 가로, 세로
        int day = Integer.parseInt(st.nextToken()); // 날짜 수
        int size = 2 * M - 1; // 왼쪽 열 + 맨 위 행의 길이

        int[] larva = new int[size];
        Arrays.fill(larva, 1);

        for(int i = 0; i < day; i++){
            st = new StringTokenizer(br.readLine());

            int idx = 0;

            for(int grow = 0; grow <= 2; grow++){
                int num = Integer.parseInt(st.nextToken());

                // grow 만큼 자라는 애벌레 처리
                for(int j = 0; j < num; j++){
                    larva[idx] += grow;
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = M-1; i >= 0; i--) { // 0 ~ M-1 가장 왼쪽 열은 그대로
            sb.append(larva[i]).append(" ");
            for (int j = M; j < size; j++) { // M ~ 2*M-2까지가 맨 위 행 값들
                sb.append(larva[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}