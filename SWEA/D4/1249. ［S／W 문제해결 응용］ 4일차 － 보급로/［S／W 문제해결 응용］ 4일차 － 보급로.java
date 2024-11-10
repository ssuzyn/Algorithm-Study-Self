import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution{
	
	static int N;
	static int[][] map;
	static int[][] minDistance;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	
	static class Node implements Comparable<Node>{
		int x, y, cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 지도의 크기 
			map = new int[N][N];
			minDistance = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = input[j] - '0';
				}
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(minDistance[i], Integer.MAX_VALUE);
			}
			
			sb.append("#" + t + " " + dijkstra() + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static int dijkstra() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0]));
		minDistance[0][0] = map[0][0];
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			if(tmp.x == N-1 && tmp.y == N-1) return tmp.cost;
			
			for(int[] d : dir) {
				int nx = tmp.x + d[0];
				int ny = tmp.y + d[1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				
				int cost = tmp.cost + map[nx][ny];
				if(minDistance[nx][ny] > cost) {
					minDistance[nx][ny] = cost;
					pq.add(new Node(nx, ny, cost));
					visited[nx][ny] = true;
				}
			}
		}
		
		return -1;
	}
}
