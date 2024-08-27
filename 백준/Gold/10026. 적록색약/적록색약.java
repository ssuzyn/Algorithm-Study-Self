import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int section = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j], false);
					section++;
				}
			}
		}
		System.out.print(section + " ");
		
		section = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j], true);
					section++;
				}
			}
		}
		System.out.println(section);
	

	}
	
	private static void dfs(int x, int y, char color, boolean blindness) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			

			if(map[nx][ny] == color) {
				dfs(nx, ny, color, blindness);
			}
			
			if(blindness) {
				if(color == 'G' && map[nx][ny] == 'R') {
					dfs(nx, ny, color, blindness);
				}
				else if(color == 'R' && map[nx][ny] == 'G') {
					dfs(nx, ny, color, blindness);
				}
			}
			
		}
	}

}
