import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, max;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    static class Node{
        int idx, weight;

        Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int idx, int depth){
        for(Node node : tree[idx]){
            if(!visited[node.idx]){
                visited[node.idx] = true;
                dfs(node.idx, depth + node.weight);
            }
        }
        max = Math.max(depth, max);
    }

}