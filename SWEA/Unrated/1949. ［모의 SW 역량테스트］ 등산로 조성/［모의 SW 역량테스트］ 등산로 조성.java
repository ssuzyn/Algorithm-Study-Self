import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	static int N, K, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 크기 
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이 
			answer = Integer.MIN_VALUE;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			int high = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					high = Math.max(map[i][j], high);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == high) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			
			
			System.out.println("#" + t + " " + answer);
			
		}
	}
	
	private static void dfs(int x, int y, int depth, boolean flag) {
		answer = Math.max(depth, answer);
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
			
			int tmpHeight = map[x][y]; // 현재 봉우리 
			int nextHeight = map[nx][ny]; // 다음 봉우리 
			
			if(nextHeight < tmpHeight) { // 다음 봉우리 < 현재 봉우리 
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, flag);
				visited[nx][ny] = false;
			}
			else if(nextHeight >= tmpHeight && !flag) { // 다음 봉우리 >= 현재 봉우리 
				for(int i = 1; i <= K; i++) {
					if(nextHeight - i < tmpHeight) {
						map[nx][ny] -= i;  
						visited[nx][ny] = true;
						dfs(nx, ny, depth + 1, true);
						map[nx][ny] += i;
						visited[nx][ny] = false;
					}
				}
			}
			
		}
	}
}