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
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.print(countSections() + " "); // 적록색약인 사람이 봤을 때
		convertMap();
		System.out.println(countSections()); // 적록색약이 아닌 사람이 봤을 때
	

	}
	
	private static void convertMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R'; // G를 R로 변환
				}
			}
		}
	}
	
	private static int countSections() {
		int section = 0;
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j]);
					section++;
				}
			}
		}
		
		return section;
	}
	
	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			

			if(map[nx][ny] == color) dfs(nx, ny, color);
		}
	}

}
