import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> water = new LinkedList<>();
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		
		map = new char[R][C];
		visited = new boolean[R][C];

		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '*') water.add(new int[] {i, j});
				else if(map[i][j] == 'S') {
					q.add(new int[] {i, j, 0});
					map[i][j] = '.';
					visited[i][j] = true;
				}
			}
		}

		int answer = bfs();
		System.out.println(answer == -1? "KAKTUS" : answer);
	}
	
	private static int bfs() {
		
		while(!q.isEmpty()) {
			
			waterBfs();
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int depth = cur[2];
				
				if(map[x][y] == 'D') return depth;
				
				for(int[] dir : d) {
					int nx = x + dir[0];
					int ny = y + dir[1];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
					
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, depth + 1});
				}
			}
		}

		return -1;
	}
	
	private static void waterBfs() {
		int size = water.size();
		
		for(int i = 0; i < size; i++) {
			int[] cur = water.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int[] dir : d) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				if(map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*') continue;
				
				map[nx][ny] = '*';
				water.add(new int[] {nx, ny});
			}
		}
		
	}
}
