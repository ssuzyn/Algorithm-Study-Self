import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, count = 0, time = 0;
	static int[][] map;
	static Queue<int[]> tomato = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) tomato.add(new int[] { i, j });
				else if (map[i][j] == 0) count++;
			}
		}

		makeTomato();
		System.out.println(count == 0 ? time-1 : -1);
	}
	

	private static void makeTomato() {
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!tomato.isEmpty()) {
			
			int size = tomato.size();

			for (int i = 0; i < size; i++) {

				int[] cur = tomato.poll();
				int x = cur[0];
				int y = cur[1];

				for (int[] d : dir) {
					int nx = x + d[0];
					int ny = y + d[1];

					if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 0){
						tomato.add(new int[] { nx, ny });
						map[nx][ny] = 1;
						count--;
					}
				}
			}
			time++;
		}

	}

}
