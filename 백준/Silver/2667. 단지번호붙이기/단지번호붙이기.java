import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N, count;
	static boolean[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = (input.charAt(j) == '1');
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j]) {
					count = 1;
					dfs(i, j);
					pq.add(count);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int x, int y) {
		map[x][y] = false;

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(isValid(nx, ny) && map[nx][ny]) {
				count++;
				dfs(nx, ny);
			}
		}

	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
