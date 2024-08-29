import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int rain = Integer.MIN_VALUE;
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rain = Math.max(map[i][j], rain);
			}
		}
		
		int section = 0;
		while(rain-- >= 1) {
			int cnt = 0;
			visit = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visit[i][j] && map[i][j] > rain) {
						bfs(i, j, rain);
						cnt++;
					}
				}
			}
			
			section = Math.max(section, cnt);
		}
		
		System.out.println(section);
		
	}
	
	static void bfs(int x, int y, int limit) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || map[nx][ny] <= limit) continue;
				
				// 물에 잠기지 않는 영역인 경우 BFS 탐색
				visit[nx][ny] = true;
				q.add(new int[] {nx, ny});
				
			}
		}
		
	}

}
