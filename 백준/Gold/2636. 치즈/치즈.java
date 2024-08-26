import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cheese;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		
		int cheeseCnt = 0; // 마지막으로 남아있던 치즈 개수
		int time = 0; // 모든 치즈가 녹을때까지 걸린 시간
		while(cheese != 0) { // 치즈가 남아있는 동안 반복
			cheeseCnt = cheese;
			time++;
			visited = new boolean[N][M];
			bfs(0, 0);
		}
		
		System.out.println(time);
		System.out.println(cheeseCnt);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			x = tmp[0];
			y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				if(map[nx][ny] == 0) { // 공기인 경우 계속 탐색
					q.offer(new int[] {nx, ny});
				}
				else { // 치즈인 경우
					cheese--; // 치즈 녹이기
					map[nx][ny] = 0;
				}
			}
		}
		
	}
	

}
