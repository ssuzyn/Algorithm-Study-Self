import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }   
    }
	
	public static void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static int find(int[]parent, int x) {
		if(parent[x] == x) return x;
		else return find(parent, parent[x]);
	}
	
	public static void kruskal(List<Edge> graph, int[] parent) {
		int cost = 0;
		for(Edge edge: graph) {
			if(find(parent, edge.start) != find(parent, edge.end)) {
				cost += edge.weight;
				union(parent, edge.start, edge.end);
			}
		}
		
		System.out.println(cost);
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> graph = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.add(new Edge(start, end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			graph.add(new Edge(0, i, weight));
		}
		
		graph.sort((o1, o2) -> o1.weight - o2.weight) ;
		
		int[] parent = new int[N + 1];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		kruskal(graph, parent);
	}

}
