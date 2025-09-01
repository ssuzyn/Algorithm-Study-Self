import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[][] nations;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		nations = new int[N][N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				nations[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;
		while(true){
			boolean check = false;
			visited = new boolean[N][N];

			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(!visited[i][j]){
						if(bfs(i, j) > 1){
							check = true;
						}
					}
				}
			}

			if(!check) break;

			days++;
		}

		System.out.println(days);
	}

	private static int bfs(int x, int y){
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> team = new LinkedList<>();

		q.add(new int[]{x, y});
		team.add(new int[]{x, y});
		int totalPeople = nations[x][y];
		visited[x][y] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			x = cur[0];
			y = cur[1];

			for(int[] d : dir){
				int nx = x + d[0];
				int ny = y + d[1];

				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				int diff = Math.abs(nations[x][y] - nations[nx][ny]);

				if(L <= diff && diff <= R){
					q.add(new int[]{nx, ny});
					visited[nx][ny] = true;
					team.add(new int[]{nx, ny});
					totalPeople += nations[nx][ny];
				}
			}
		}

		int cnt = team.size();
		if(cnt > 1){
			int avg = totalPeople / cnt;
			while(!team.isEmpty()){
				int[] cur = team.poll();
				nations[cur[0]][cur[1]] = avg;
			}
		}

		return cnt;
	}
}