import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static long[] minDistance;
    static int[] enemy;
    static ArrayList<Node>[] graph;

    static class Node{
        int v;
        long cost;

        public Node(int v, long cost){
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        graph = new ArrayList[V];
        enemy = new int[V];
        minDistance = new long[V];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < V; i++){
            enemy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w)); // 양방향 그래프
        }

        Arrays.fill(minDistance, Long.MAX_VALUE);
        dijkstra();

        System.out.println(minDistance[V-1] == Long.MAX_VALUE? -1 : minDistance[V-1]);
    }

    private static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1.cost, n2.cost));
        pq.add(new Node(0, 0));
        minDistance[0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(minDistance[cur.v] < cur.cost) continue;

            for(Node next : graph[cur.v]){
                // 목적지가 아닌 경우 적이 있는 노드는 방문X
                if(next.v < V-1 && enemy[next.v] == 1) continue;

                long cost = minDistance[cur.v] + next.cost;
                if(cost < minDistance[next.v]){
                    minDistance[next.v] = cost;
                    pq.add(new Node(next.v, cost));
                }
            }
        }
    }
}
