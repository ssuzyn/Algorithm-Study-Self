import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 배추 개수

			map = new int[N][M];
			visited = new boolean[N][M];
			List<int[]> cabbage = new ArrayList<>();
			for(int i = 0; i < K; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				cabbage.add(new int[]{x, y});
			}

			int count = 0;
			for(int[] c : cabbage){
				int x = c[0], y = c[1];
				if(visited[x][y]) continue;
				bfs(x, y);
				count++;
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}

	private static void bfs(int x, int y){
		int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];

			for(int[] d : dir){
				int nx = x + d[0];
				int ny = y + d[1];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				q.add(new int[]{nx, ny});
			}
		}
	}
}
