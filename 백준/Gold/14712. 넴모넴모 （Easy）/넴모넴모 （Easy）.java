import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = 0;
    static boolean[][] picked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        picked = new boolean[N][M];

        batch(0, 0);

        System.out.println(answer);

    }

    private static void batch(int start, int cnt){

        if(!isSquare(cnt)) answer++;

        if(cnt == N * M) return;

        for(int i = start; i < N * M; i++){
            int x = i / M; int y = i % M;

            if(!picked[x][y]){
                picked[x][y] = true;
                batch(i + 1, cnt + 1);
                picked[x][y] = false;
            }
        }
    }

    private static boolean isSquare(int cnt){
        if(cnt < 4) return false;

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-1; j++){
                if(picked[i][j] && picked[i][j+1] &&
                    picked[i+1][j] && picked[i+1][j+1]){
                    return true;
                }
            }
        }
        return false;
    }

}
