import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈
        int[] money = new int[N + 1]; // 각 학생이 원하는 친구 비
        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(findParent(a) != findParent(b)) union(a, b);
        }

        List<Integer>[] friend = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            friend[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            friend[findParent(parent[i])].add(money[i]); // 각 그룹내에서 친구비
        }

        int answer = 0;
        for(int i = 1; i<= N; i++){
            if(friend[i].isEmpty()) continue;
            answer += Collections.min(friend[i]);
        }

        System.out.println(answer <= K ? answer : "Oh no");
    }

    private static void union(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);

        if(rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    private static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
}