import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int group = 1;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(map[i][j] == 1 && !visited[i][j]){
					setLandGroup(i, j, group++);
				}
			}
		}

		answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(map[i][j] > 0 && isEdge(i, j)){
					visited = new boolean[N][N];
					findBridge(i, j, map[i][j]);
				}
			}
		}

		System.out.println(answer);
	}

	private static boolean isValid(int x, int y){
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	private static void setLandGroup(int x, int y, int group){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;
		map[x][y] = group;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];

			for(int[] d : dir){
				int nx = x + d[0];
				int ny = y + d[1];

				if(!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

				visited[nx][ny] = true;
				map[nx][ny] = group;
				q.add(new int[]{nx, ny});
			}
		}
	}

	private static boolean isEdge(int x, int y){
		for(int[] d : dir){
			int nx = x + d[0];
			int ny = y + d[1];

			if(isValid(nx, ny) && map[nx][ny] == 0) return true;
		}

		return false;
	}

	private static void findBridge(int x, int y, int group) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, 0});
		visited[x][y] = true;

		while (!q.isEmpty()){
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];
			int length = cur[2];

			if (length >= answer) continue;

			for (int[] d : dir) {
				int nx = x + d[0];
				int ny = y + d[1];

				if (!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] == group) continue;
				if(map[nx][ny] == 0){
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny, length + 1});
				}
				else{
					answer = Math.min(answer, length);
				}

			}
		}
	}
}