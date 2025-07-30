import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	static int answer = 0;
	static char[][] map = new char[5][5];
	static boolean[] visited = new boolean[1 << 25];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++){
			map[i] = br.readLine().toCharArray();
		}

		// 모든 'S' 위치에서 시작
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(map[i][j] == 'S'){
					dfs(1, 0, 1 << (i * 5 + j));
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int count, int yeon, int mask){
		if(yeon > 3) return;

		if(count == 7){
			answer++;
			return;
		}

		// 현재 선택된 위치들에서 인접한 곳으로 확장
		for(int i = 0; i < 25; i++){
			if((mask & (1 << i)) == 0) continue; // 선택되지 않은 위치는 패스

			int x = i / 5;
			int y = i % 5;

			for(int dir = 0; dir < 4; dir++){
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

				int nextPos = nx * 5 + ny;
				int nextMask = mask | (1 << nextPos);

				if(visited[nextMask]) continue;

				visited[nextMask] = true;
				dfs(count + 1, map[nx][ny] == 'Y'? yeon + 1 : yeon, nextMask);
			}
		}
	}
}