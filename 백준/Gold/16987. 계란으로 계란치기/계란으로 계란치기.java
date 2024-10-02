import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer = 0;
    static int[][] egg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 계란 개수
        egg = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }
        solve(0, 0);
        System.out.println(answer);
    }

    private static void solve(int turn, int cnt) {
        if(cnt == N-1 || turn == N){
            answer = Math.max(cnt, answer);
            return;
        }

        if(egg[turn][0] <= 0) { // 현재 들고 있는 계란이 깨진 경우
            solve(turn + 1, cnt);
        }
        else{
            for(int i = 0; i < N; i++){
                if (i == turn || egg[i][0] <= 0) continue; // 자신이나 깨진 계란 제외

                egg[turn][0] -= egg[i][1];
                egg[i][0] -= egg[turn][1];

                solve(turn + 1, cnt + (egg[turn][0] <= 0? 1 : 0) + (egg[i][0] <= 0? 1 : 0));

                egg[turn][0] += egg[i][1];
                egg[i][0] += egg[turn][1];
            }
        }
    }
}
