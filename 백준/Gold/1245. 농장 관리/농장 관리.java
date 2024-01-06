import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int m;
	public static int[][] farmMap;
	public static boolean[][] visited;
	public static int result = 0;
	public static boolean peak;
	
	
	static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};
	
    public static boolean isValid(int x, int y) {
    	return x >= 0 && x < n && y >= 0 && y < m;
    }
    
	public static void mountainPeak(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(isValid(newX, newY)) {
				if(farmMap[newX][newY] > farmMap[x][y]) {
					peak = false;
				}
				else if(!visited[newX][newY] && farmMap[newX][newY] == farmMap[x][y]) {
					mountainPeak(newX, newY);
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		farmMap = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				farmMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) {
					peak = true;
					mountainPeak(i, j);
					if(peak) result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
