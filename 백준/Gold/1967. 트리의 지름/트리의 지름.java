import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, max, farNode;
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
        for(int i = 0; i <= N; i++){
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

        // 1번 노드에서 가장 먼 노드를 찾기 위한 DFS
        max = 0;
        visited = new boolean[N + 1];
        dfs(1, 0); // 임의의 시작점에서 가장 먼 노드 찾기

        // 가장 먼 노드에서 다시 DFS로 트리의 지름을 구함
        max = 0;
        visited = new boolean[N + 1];
        dfs(farNode, 0); // 가장 먼 노드로부터 가장 먼 거리의 노드 찾기

        System.out.println(max);
    }

    private static void dfs(int idx, int distance){
        visited[idx] = true;

        if(distance > max){
            max = distance;
            farNode = idx;
        }

        for(Node node : tree[idx]){
            if(!visited[node.idx]){
                dfs(node.idx, distance + node.weight);
            }
        }
    }

}