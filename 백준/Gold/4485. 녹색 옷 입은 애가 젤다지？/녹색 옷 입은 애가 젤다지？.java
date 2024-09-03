import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			System.out.println("Problem " + (test++) + ": " + dijkstra(0, 0, N-1, N-1));
			
		}
		
	}
	
	
	static int dijkstra(int sx, int sy, int ex, int ey) {
		
		boolean[][] visited = new boolean[N][N];
		int[][] minRupee = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(minRupee[i], Integer.MAX_VALUE);
		}
		
		minRupee[sx][sy] = map[sx][sy]; // 시작 정점 비용 초기화
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.offer(new int[] {sx, sy, minRupee[sx][sy]});
		
		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			int x = node[0];
			int y = node[1];
			int cost = node[2];
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			if(x == ex && y == ey) return cost;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				if(minRupee[nx][ny] > cost + map[nx][ny]) {
					minRupee[nx][ny] = cost + map[nx][ny];
					pq.offer(new int[] {nx, ny, minRupee[nx][ny]});
				}
			}
		}
		
		
		return -1;
	}

}
