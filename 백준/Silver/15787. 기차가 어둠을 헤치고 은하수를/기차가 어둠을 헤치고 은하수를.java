import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] train;
    static Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 기차의 수
        M = Integer.parseInt(st.nextToken()); // 명령의 수
        train = new int[N + 1];

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int j = Integer.parseInt(st.nextToken());
                train[i] |= (1 << (j - 1));
            }
            else if(cmd == 2){
                int j = Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << (j - 1));
            }
            else if(cmd == 3){
                train[i] &= ~(1 << 19);
                train[i] <<= 1;
            }
            else {
                train[i] &= ~1;
                train[i] >>= 1;
            }
        }

        for(int i = 1; i <= N; i++) {
            result.add(train[i]);
        }
        System.out.println(result.size());
    }
}
