import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static char[][] map;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		int[][] coins = new int[2][2];
		int idx = 0;

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];
				if (map[i][j] == 'o') {
					coins[idx][0] = i;
					coins[idx][1] = j;
					idx++;
					map[i][j] = '.';
				}
			}
		}

		int result = bfs(coins[0][0], coins[0][1], coins[1][0], coins[1][1]);
		System.out.println(result);
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M][N][M];
		q.add(new int[]{x1, y1, x2, y2, 0});
		visited[x1][y1][x2][y2] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx1 = cur[0], cy1 = cur[1], cx2 = cur[2], cy2 = cur[3], cnt = cur[4];

			if (cnt >= 10) continue;

			for (int[] d : dir) {
				int nx1 = cx1 + d[0];
				int ny1 = cy1 + d[1];
				int nx2 = cx2 + d[0];
				int ny2 = cy2 + d[1];

				boolean fall1 = !isValid(nx1, ny1);
				boolean fall2 = !isValid(nx2, ny2);

				if (fall1 && fall2) continue; // 둘 다 떨어짐 → 실패
				if (fall1 ^ fall2) return cnt + 1; // 하나만 떨어짐 → 성공

				// 벽에 부딪히면 이동하지 않음
				if (!fall1 && map[nx1][ny1] == '#') {
					nx1 = cx1;
					ny1 = cy1;
				}
				if (!fall2 && map[nx2][ny2] == '#') {
					nx2 = cx2;
					ny2 = cy2;
				}

				if (!visited[nx1][ny1][nx2][ny2]) {
					visited[nx1][ny1][nx2][ny2] = true;
					q.add(new int[]{nx1, ny1, nx2, ny2, cnt + 1});
				}
			}
		}

		return -1; // 10번 이내에 불가능
	}

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
