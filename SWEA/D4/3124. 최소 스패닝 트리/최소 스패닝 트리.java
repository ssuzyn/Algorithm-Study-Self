import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static long V, E;
	static long[] parent;
	
	static class Edge implements Comparable<Edge>{
		int start, end;
		long weight;

		public Edge(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static void make() {
		parent = new long[(int)(V + 1)];
		for(int i = 1; i <= V; i++) {
			parent[i] = -1;
		}
	}
	
	static long findParent(int x) {
		if(parent[x] < 0) return x;
		return parent[x] = findParent((int)parent[x]);
	}
	
	static boolean union(int a, int b) {
		long rootA = findParent(a);
		long rootB = findParent(b);
		if(rootA == rootB) return false;
		
		parent[(int)rootA] += parent[(int)rootB];
		parent[(int)rootB] = rootA;
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Long.parseLong(st.nextToken());
			E = Long.parseLong(st.nextToken());
			
			Edge[] edges = new Edge[(int)E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
						,Long.parseLong(st.nextToken()));
			}
			
			Arrays.sort(edges);
			make();
			
			long cost = 0, cnt = 0;
			for(Edge edge: edges) {
				if(union(edge.start, edge.end)) {
					cost += edge.weight;
					if(++cnt == V) break;
				}
			}
			
			System.out.println("#" + t + " " + cost);
		}
	}
}
