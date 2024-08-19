import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    static int N, M, answer;
    static boolean[][] notGood;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 아이스크림 종류의 수
        M = Integer.parseInt(st.nextToken()); // 섞어먹으면 안되는 조합의 개수
        notGood = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int ice1 = Integer.parseInt(st.nextToken());
            int ice2 = Integer.parseInt(st.nextToken());
            notGood[ice1][ice2] = true;
            notGood[ice2][ice1] = true;
        }

        answer = 0;
        solve();
        System.out.println(answer);

    }

    private static void solve(){
        for(int i = 1; i <= N - 2; i++){
            for(int j = i + 1; j <= N - 1; j++){
                if(notGood[i][j]){
                    continue;
                }

                for(int k = j + 1; k <= N; k++){
                    if(notGood[i][k] || notGood[j][k]){
                        continue;
                    }
                    answer++;
                }
            }
        }
    }
}