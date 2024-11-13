import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static PriorityQueue<Edge> pq;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int start, end, length;

		Edge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.length, o.length);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		visited = new boolean[N][M];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 섬 구분하기
		cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					setIsland(i, j, cnt++);
				}
			}
		}
		cnt--;

		// 2. 만들 수 있는 다리 간선 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					findBridge(i, j, map[i][j]);
				}
			}
		}

		// 3. 모든 섬을 연결할 수 있는 다리 잇기
		int answer = 0;
		int bridge = 0;
		make();
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.start, edge.end)) {
				answer += edge.length;
				bridge++;
			}

			if (bridge == cnt - 1) {
				System.out.println(answer);
				return;
			}
		}
		System.out.println(-1);
	}
	
	private static void make() {
		parent = new int[cnt+1];
		for (int i = 0; i <= cnt; i++) {
			parent[i] = i;
		}
	}

	private static int findParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findParent(parent[x]);
	}

	private static boolean union(int a, int b) {
		int rootA = findParent(a);
		int rootB = findParent(b);

		if (rootA != rootB) {
			parent[rootB] = rootA;
			return true;
		}
		return false;
	}
	
	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	private static void findBridge(int x, int y, int group) {
		
		for(int[] dir : d) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if(!isValid(nx, ny) || map[nx][ny] == group) continue;
			
			int bridge = 0;
			while(map[nx][ny] == 0) {
				bridge++;
				nx += dir[0];
				ny += dir[1];
				if(!isValid(nx, ny)) break;
			}
			
			if(isValid(nx, ny) && map[nx][ny] != group) {
				if(bridge >= 2) {
					pq.add(new Edge(group, map[nx][ny], bridge));
				}
			}
		}
	}

	private static void setIsland(int x, int y, int idx) {
		Queue<int[]> q = new LinkedList<>();
		map[x][y] = idx;
		visited[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];

			for (int[] dir : d) {
				int nx = x + dir[0];
				int ny = y + dir[1];

				if (!isValid(nx, ny) || visited[nx][ny]) continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = idx;
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

}
