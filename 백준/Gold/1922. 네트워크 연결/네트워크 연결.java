import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}
	
	static int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
	
	static boolean union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int M = Integer.parseInt(br.readLine()); // 간선 수
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		int totalCost = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.start, edge.end)) {
				totalCost += edge.cost;
				if(++cnt == N - 1) break;
			}
		}
		
		System.out.println(totalCost);
			
	}

}
