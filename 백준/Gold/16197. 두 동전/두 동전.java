import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static char[][] map;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new char[N][M];

		int idx = 0;
		int[][] coin = new int[2][2];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++){
				if(map[i][j] == 'o') {
					coin[idx++] = new int[]{i, j};
					map[i][j] = '.';
				}
			}
		}

		answer = Integer.MAX_VALUE;
		dfs(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0);
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}

	private static void dfs(int x1, int y1, int x2, int y2, int cnt){
		if(cnt > 10) return;

		boolean coin1Out = !isValid(x1, y1);
		boolean coin2Out = !isValid(x2, y2);

		// 둘 다 떨어짐 - 실패
		if(coin1Out && coin2Out) {
			return;
		}

		// 하나만 떨어짐 - 성공
		if(coin1Out || coin2Out) {
			answer = Math.min(answer, cnt);
			return;
		}

		for(int[] d : dir){
			int nx1 = x1 + d[0];
			int nx2 = x2 + d[0];
			int ny1 = y1 + d[1];
			int ny2 = y2 + d[1];

			if(!canGo(nx1, ny1)) {
				nx1 = x1;
				ny1 = y1;
			}
			if(!canGo(nx2, ny2)){
				nx2 = x2;
				ny2 = y2;
			}

			dfs(nx1, ny1, nx2, ny2, cnt + 1);
		}

	}

	private static boolean canGo(int x, int y){
		// 보드 안에 있으면서 벽인 경우에만 이동 불가
		if(isValid(x, y) && map[x][y] == '#') {
			return false;
		}
		return true;
	}

	private static boolean isValid(int x, int y){
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}