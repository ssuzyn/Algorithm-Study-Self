import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	static class Edge{
		int a, b;
		int cost;

		Edge(int a, int b, int cost){
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}

	private static int findParent(int x){
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}

	private static boolean union(int a, int b){
		int rootA = findParent(a);
		int rootB = findParent(b);

		if(rootA != rootB){
			parent[rootB] = rootA;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int M = Integer.parseInt(st.nextToken()); // 길의 개수

		PriorityQueue<Edge> pq = new PriorityQueue<>((c1, c2) -> c1.cost - c2.cost);
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a, b, cost));
		}

		parent = new int[N+1];
		for(int i = 1; i <= N; i++){
			parent[i] = i;
		}

		int answer = 0;
		int count = 0;
		int maxCost = 0;
		while(!pq.isEmpty()){
			Edge com = pq.poll();
			if(union(com.a, com.b)){
				answer += com.cost;
				maxCost = Math.max(maxCost, com.cost);
				if(++count == N-1) break;
			}
		}

		System.out.println(answer - maxCost);
	}

}
