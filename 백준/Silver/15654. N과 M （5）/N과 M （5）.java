import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 자연수
        M = Integer.parseInt(st.nextToken()); // 길이가 M인 수열
        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        pickNumber(0, new int[M]);
        System.out.println(sb);
    }

    private static void pickNumber(int cnt, int[] picked){
        if(cnt == M){
            for(int num : picked){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;

            picked[cnt] = numbers[i];
            visited[i] = true;
            
            pickNumber(cnt + 1, picked);
            visited[i] = false;
        }
    }
}
