import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // 지도의 너비
			H = Integer.parseInt(st.nextToken()); // 지도의 높이
			
			if(W == 0 && H == 0) break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int land = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						land++;
					}
				}
			}
			sb.append(land).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= H || ny < 0 || ny >= W || visited[nx][ny]) continue;
			
			if(map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}
