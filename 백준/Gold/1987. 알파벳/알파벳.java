import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int R, C, maxCnt = 0;
	static char[][] map;
	static boolean[] alphabet = new boolean[26];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); // 세로
		C = Integer.parseInt(input[1]); // 가로
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		alphabet[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(maxCnt);
	}
	
	private static void dfs(int x, int y, int cnt) {
		maxCnt = Math.max(maxCnt, cnt); // 최대 칸 수 갱신
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(alphabet[map[nx][ny] - 'A']) continue; // 이미 방문한 알파벳은 무시
			
			alphabet[map[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			alphabet[map[nx][ny] - 'A'] = false; // 백트래킹
		}
	}

}
