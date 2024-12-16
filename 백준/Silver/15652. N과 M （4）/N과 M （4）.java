import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 자연수
        M = Integer.parseInt(st.nextToken()); // 길이가 M인 수열

        pickNumber(1, 0, new int[M]);
        System.out.println(sb);
    }

    private static void pickNumber(int start, int cnt, int[] picked){
        if(cnt == M){
            for(int num : picked){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            picked[cnt] = i;
            pickNumber(i, cnt + 1, picked); // 같은 수 선택 가능
        }
    }
}
