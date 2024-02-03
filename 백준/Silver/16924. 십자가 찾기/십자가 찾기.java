import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static char[][] grid;
	static int count;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int x, int y) {
		
		int size = 0;
		if(grid[x][y] == '*') {
			for(int k=1; ; k++) {
				if(x-k >= 0 && x+k < N && y-k >=0 && y+k < M) {
					if(grid[x-k][y] == '*' && grid[x+k][y] == '*' && grid[x][y-k] == '*' && grid[x][y+k] == '*') {
						size = k;
					}
					else break;
				}
				else break;
			}
		}
		
		if(size > 0) {
			visited[x][y] = true;
			for(int k = 1; k <= size; k++) {
				visited[x-k][y] = true;
				visited[x+k][y] = true;
				visited[x][y-k] = true;
				visited[x][y+k] = true;
				
				count++;
				sb.append((x+1) + " " + (y+1) + " " + size).append("\n");
				
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		grid = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(i, j);
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == '*' && visited[i][j] == false) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(sb.toString());
		
	}

}
