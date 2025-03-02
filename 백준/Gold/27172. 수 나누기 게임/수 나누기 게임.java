import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];
        int[] score = new int[1000001]; // 각 번호에 대한 점수
        boolean[] visited = new boolean[1000001]; // 숫자 존재 여부

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            visited[cards[i]] = true;
        }

        for(int i = 0; i < N; i++){
            int tmp = cards[i];
            for(int j = 1; j <= (int)Math.sqrt(tmp); j++){
                if(tmp % j == 0){ // j가 tmp의 약수인 경우
                    if(visited[j]){
                        score[j] += 1;
                        score[tmp] -= 1;
                    }
                    if(j * j != tmp && visited[tmp/j]){
                        score[tmp/j] += 1;
                        score[tmp] -= 1;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(score[cards[i]] + " ");
        }
        System.out.println(sb);
    }

}
