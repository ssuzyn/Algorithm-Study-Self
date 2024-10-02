import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new char[N][M];
		
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == '0') {
					x = i; y = j;
				}
			}
			map[i] = line.toCharArray();
		}
		
		map[x][y] = '.';
		System.out.println(escapeMaze(x, y));
		
	}
	
	private static int escapeMaze(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0, 0});
		boolean[][][] visited = new boolean[N][M][64];
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];
			int key = cur[2]; // 현재 열쇠 상태
			int depth = cur[3]; // 이동한 거리
			
			if(map[x][y] == '1') return depth;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				char next = map[nx][ny];
				if(next == '#') continue; // 벽인 경우
				
				int newKey = key;
				if(next >= 'a' && next <= 'f') { // 열쇠인 경우 열쇠 얻기
					newKey |= (1 << (next - 'a'));
				}
				
				if(next >= 'A' && next <= 'F') { // 문인 경우 열쇠가 없으면 지나갈 수 없다.
					if((key & (1 << next - 'A')) == 0) continue;
				}
				
				if(!visited[nx][ny][newKey]) {
					visited[nx][ny][newKey] = true;
					q.offer(new int[] {nx, ny, newKey, depth + 1});
				}
			}
		}
		
		return -1;
	}

}
