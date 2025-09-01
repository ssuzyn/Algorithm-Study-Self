import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[][] nations;
	static boolean[][] visited;

	static class Team{
		List<int[]> positions; // 연합에 속한 나라들의 위치
		int totalPeople;       // 총 인구수

		Team(){
			this.positions = new ArrayList<>();
			this.totalPeople = 0;
		}
	}

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
			visited = new boolean[N][N];
			List<Team> teams = new ArrayList<>();

			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(!visited[i][j]){
						Team team = bfs(i, j);
						if(team.positions.size() > 1) teams.add(team);
					}
				}
			}

			// 더 이상 연합이 형성되지 않으면 종료
			if(teams.isEmpty()) break;

			// 각 연합의 인구수 업데이트
			for(Team team : teams){
				int avgPeople = team.totalPeople / team.positions.size();
				for(int[] pos : team.positions){
					nations[pos[0]][pos[1]] = avgPeople;
				}
			}
			days++;
		}

		System.out.println(days);
	}

	private static Team bfs(int x, int y){
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> q = new LinkedList<>();
		Team team = new Team();

		q.add(new int[]{x, y});
		visited[x][y] = true;
		team.positions.add(new int[]{x, y});
		team.totalPeople += nations[x][y];

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
					team.positions.add(new int[]{nx, ny});
					team.totalPeople += nations[nx][ny];
				}
			}
		}

		return team;
	}
}