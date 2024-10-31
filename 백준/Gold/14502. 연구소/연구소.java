import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, maxSize;
	static int[][] origin;
	static int[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		maxSize = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pickWall(0, 0, new int[3]);
		System.out.println(maxSize);
	}
	
	private static void pickWall(int cnt, int start, int[] picked) {
		if(cnt == 3) {
			map = copyMap();
			for(int i = 0; i < 3; i++) {
				int x = picked[i] / M;
				int y = picked[i] % M;
				map[x][y] = 1; // 벽 세우기
			}

			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2 && !visited[i][j]) virus(i, j);
				}
			}

			maxSize = Math.max(checkSafeArea(), maxSize);
			return;
		}
		
		for(int i = start; i < N * M; i++) {
			if(origin[i / M][i % M] == 0) {
				picked[cnt] = i;
				pickWall(cnt+ 1, i + 1, picked);
			}
		}
	}
	
	private static int[][] copyMap() {
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
	
	private static void virus(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];
			
			for(int[] dir : d) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
					map[nx][ny] = 2;
				}
			}
		}
	}
	
	private static int checkSafeArea() {
		int size = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) size++;
			}
		}
		return size;
		
	}
}
