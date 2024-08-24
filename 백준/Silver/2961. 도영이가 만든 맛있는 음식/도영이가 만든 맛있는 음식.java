import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, minDiff;
    static int[][] food;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 재료의 개수
        food = new int[N][2];
        minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            food[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        cook(0, 0, 1, 0);
        System.out.println(minDiff);

    }

    private static void cook(int cnt, int start, int sour, int bitter){
        if(cnt == N && bitter > 0){
            minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            return;
        }

        for(int i = start; i < N; i++){
            cook(cnt + 1, i + 1, sour * food[i][0], bitter + food[i][1]);
            cook(cnt + 1, i + 1, sour, bitter);
        }
    }
}
