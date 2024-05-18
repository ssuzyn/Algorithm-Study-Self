import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int M, N;
	
	private static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
	
	private static void dfs(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(isValid(newX, newY) && !visited[newX][newY] && field[newX][newY] == 1) {
				visited[newX][newY] = true;
				dfs(newX, newY);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			visited = new boolean[M][N];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}
			
			int earthWorm = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && field[i][j] == 1) {
						dfs(i, j);
						earthWorm++;
					}
				}
			}
			
			System.out.println(earthWorm);
		}
		
		
		

	}

}
