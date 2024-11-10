import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] minDistance;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	
	static class Node{
		int x, y, cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			minDistance = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(minDistance[i], Integer.MAX_VALUE);
			}
			
			dijkstra();
			sb.append("Problem " + test + ": " + minDistance[N-1][N-1] + "\n");
			test++;
		}
		
		System.out.println(sb);

	}
	
	private static void dijkstra() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
			return n1.cost - n2.cost;
		});
		pq.add(new Node(0, 0, map[0][0]));
		minDistance[0][0] = map[0][0];
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			if(minDistance[tmp.x][tmp.y] < tmp.cost) continue;
			if(tmp.x == N-1 && tmp.y == N-1) break;
			
			for(int[] d : dir) {
				int nx = tmp.x + d[0];
				int ny = tmp.y + d[1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				
				int cost = minDistance[tmp.x][tmp.y] + map[nx][ny];
				if(minDistance[nx][ny] > cost) {
					minDistance[nx][ny] = cost;
					pq.add(new Node(nx, ny, cost));
					visited[nx][ny] = true;
				}
			}
		}
	}

}
