import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] map;
	static boolean[][] visited;
	static int N, count;
	static List<Integer> houses = new ArrayList<>();
	
	private static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(isValid(newX, newY) && !visited[newX][newY] && map[newX][newY] == 1) {
				count++;
				dfs(newX, newY);
			}
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count = 1;
					dfs(i, j);
					houses.add(count);
				}
				
			}
		}
		
		Collections.sort(houses);
		
		System.out.println(houses.size());
		for(int h : houses) {
			System.out.println(h);
		}
		
	}

}
