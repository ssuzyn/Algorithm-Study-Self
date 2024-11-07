import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cheese, time, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N][M];
		cheese = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese++;
			}
		}

		time = 0;
		cnt = cheese;
		bfs(0, 0);
		
		System.out.println(time);
		System.out.println(cnt);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];
		q.add(new int[] { x, y });
		visited[x][y] = true;
		
		time++;
		cnt = cheese;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];

			for (int[] d : dir) {
				int nx = x + d[0];
				int ny = y + d[1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				if (map[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
				} else if (map[nx][ny] == 1) {
					map[nx][ny] = 0;
					cheese--;
				}
			}
		}
		
		if(cheese > 0) bfs(0, 0);
	}
	
}
