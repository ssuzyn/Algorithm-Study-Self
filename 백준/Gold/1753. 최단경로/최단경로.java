import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;
	static int[] minDistance;
	static ArrayList<Node>[] graph;
	
	static class Node{
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int start = Integer.parseInt(br.readLine()); // 시작 정점
		graph = new ArrayList[V + 1];
		minDistance = new int[V + 1];
		
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, cost));
		}
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(minDistance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(minDistance[i] + "\n");
		}
		
		System.out.print(sb.toString()); // 결과 출력
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		pq.offer(new Node(start, 0));
		minDistance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.v; // 현재 정점
			
			// 이미 처리된 노드라면 넘어간다.
			if(minDistance[cur] < node.cost) continue;
			
			for(Node next : graph[cur]) {
				int cost = minDistance[cur] + next.cost;
				
				if(cost < minDistance[next.v]) {
					minDistance[next.v] = cost;
					pq.offer(new Node(next.v, cost));
				}
			}
		}
	}
}
