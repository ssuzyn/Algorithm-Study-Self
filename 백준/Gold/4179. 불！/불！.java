import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		char[][] map = new char [R][C];
		boolean[][] visited = new boolean[R][C]; // 지훈이 방문 체크

		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> jihun = new LinkedList<>();
		int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

		for(int i = 0; i < R; i++){
			String input = br.readLine();
			for(int j = 0; j < C; j++){
				map[i][j] = input.charAt(j);

				if(map[i][j] == 'J') {
					jihun.add(new int[]{i, j});
					visited[i][j] = true;
				}
				else if(map[i][j] == 'F') fire.add(new int[]{i, j});
			}
		}

		// 지훈이가 초기 위치에서 가장자리에 있는 경우 바로 탈출 가능
		int[] start = jihun.peek();
		if(start[0] == 0 || start[1] == 0 || start[0] == R-1 || start[1] == C-1) {
			System.out.println(1);
			return;
		}

		int time = 0;
		while(!jihun.isEmpty()){
			time++;

			int fireSize = fire.size();
			for(int i = 0; i < fireSize; i++){
				int[] tmp = fire.poll();

				for(int[] d : dir){
					int nx = tmp[0] + d[0];
					int ny = tmp[1] + d[1];

					if(isValid(nx, ny) && map[nx][ny] != '#' && map[nx][ny] != 'F'){
						map[nx][ny] = 'F';
						fire.add(new int[]{nx, ny});
					}
				}
			}

			int jihunSize = jihun.size();
			for(int i = 0; i < jihunSize; i++){
				int[] tmp = jihun.poll();

				for(int[] d : dir){
					int nx = tmp[0] + d[0];
					int ny = tmp[1] + d[1];

					if(!isValid(nx, ny)){
						System.out.println(time);
						return;
					}

					if(!visited[nx][ny] && map[nx][ny] == '.'){
						visited[nx][ny] = true;
						jihun.add(new int[]{nx, ny});
					}
				}
			}
			if(jihun.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}

	}

	private static boolean isValid(int x, int y){
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
