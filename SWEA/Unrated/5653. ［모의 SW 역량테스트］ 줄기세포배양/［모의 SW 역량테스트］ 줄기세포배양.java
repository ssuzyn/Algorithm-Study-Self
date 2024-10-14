import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static PriorityQueue<Cell> pq;

	static class Cell {
		int x, y, life, time;

		Cell(int x, int y, int life, int time) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 배양 시간
			visited = new boolean[N + 2 * K][M + 2 * K]; // 크기 확보

			pq = new PriorityQueue<>((c1, c2) -> {
				return c2.life - c1.life;
			});

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						visited[i + K][j + K] = true;
						pq.add(new Cell(i + K, j + K, life, life)); // 초기 세포 추가
					}
				}
			}

			bfs();
			
			sb.append("#" + t + " " + pq.size() + "\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Cell> q = new LinkedList<>();
		
		while (K-- > 0) {
			while (!pq.isEmpty()) {
				Cell cell = pq.poll();
				cell.time--;

				if (cell.time < 0) {
					for (int i = 0; i < 4; i++) {
						int nx = cell.x + d[i][0];
						int ny = cell.y + d[i][1];

						if(visited[nx][ny]) continue;
						
						visited[nx][ny] = true;
						q.offer(new Cell(nx, ny, cell.life, cell.life));
					}
				}
				
				if(cell.life + cell.time == 0) continue;
				q.offer(cell);
			}
			
			while(!q.isEmpty()) pq.offer(q.poll());
		}

	}
}
