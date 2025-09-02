import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<List<Node>> farm = new ArrayList<>();

	static class Node{
		int idx;
		int cost;

		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 0; i <= N; i++){
			farm.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			farm.get(a).add(new Node(b, cost));
			farm.get(b).add(new Node(a, cost));
		}

		System.out.println(dijkstra());
	}

	private static int dijkstra(){
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		int[] minCost = new int[N + 1];

		pq.add(new Node(1, 0));
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[1] = 0;

		while(!pq.isEmpty()){
			Node tmp = pq.poll();

			if(tmp.cost > minCost[tmp.idx]) continue;
			if(tmp.idx == N) return minCost[N];

			for(Node next : farm.get(tmp.idx)){
				int newCost = minCost[tmp.idx] + next.cost;
				if(minCost[next.idx] > newCost){
					minCost[next.idx] = newCost;
					pq.add(new Node(next.idx, newCost));
				}
			}
		}

		return minCost[N];
	}
}