import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    
    static int N;
    static int[] pair;
    
    static int findPair(int x) {
        if(pair[x] == x) return x;
        return pair[x] = findPair(pair[x]); // 경로 압축
    }
    
    static void union(int a, int b) {
        int rootA = findPair(a);
        int rootB = findPair(b);
        
        if(rootA != rootB) {
            pair[rootB] = rootA; // rootA가 rootB를 포함하게 만듦
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            pair = new int[N+1];
            for(int i = 1; i <= N; i++) {
                pair[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                union(n1, n2);
            }
            
            // 최종적으로 각 노드의 루트를 갱신
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                if(findPair(i) == i) answer++;
            }
            
            System.out.println("#" + t + " " + answer);
        }
    }
}
