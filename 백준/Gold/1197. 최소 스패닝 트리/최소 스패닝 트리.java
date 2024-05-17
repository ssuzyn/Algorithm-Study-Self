import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	private int nodeA;
	private int nodeB;
	private int distance;
	
	public Edge(int nodeA, int nodeB, int distance) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.distance - e.distance;
	}
}


public class Main {

	static int V, E;
	static int answer = 0;
	static int[] parent;
	static ArrayList<Edge> edges = new ArrayList<>();
	
	private static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, cost));
		}
		
		Collections.sort(edges);
		
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < edges.size(); i++) {
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			int cost = edges.get(i).getDistance();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				answer += cost;
			}
		}
		
		System.out.println(answer);
	}

}
