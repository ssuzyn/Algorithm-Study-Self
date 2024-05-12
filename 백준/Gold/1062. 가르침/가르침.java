import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static String[] words;
    static int N, K;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 남극의 단어 갯수
        K = Integer.parseInt(st.nextToken()); // 쌤이 가르치는 글자 갯수
        
        if (K < 5) {
            System.out.println(0); // 읽을 수 있는 단어가 없음
            return;
        } else if (K == 26) {
            System.out.println(N); // 모든 단어를 읽을 수 있음
            return;
        }
        
        visit = new boolean[26];
        words = new String[N];
        
        // 'a', 'c', 'i', 'n', 't'는 무조건 필요
        int[] essential = {0, 2, 8, 13, 19};
        for (int e : essential) visit[e] = true;
        
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            words[i] = tmp.substring(4, tmp.length() - 4);
        }
        
        dfs(0, 0, K - 5);
        System.out.println(answer);
    }
    
    private static void dfs(int depth, int start, int max) {
        if (depth == max) {
            int count = 0;
            for (String word : words) {
                boolean status = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!visit[word.charAt(j) - 'a']) {
                        status = false;
                        break;
                    }
                }
                if (status) count++;
            }
            answer = Math.max(count, answer);
            return;
        }
        
        for (int i = start; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1, max);
                visit[i] = false;
            }
        }
    }
}
