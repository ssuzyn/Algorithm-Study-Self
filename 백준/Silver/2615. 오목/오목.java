import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[19][19];
	static int[][] dir = new int[][]{{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 19; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < 19; i++){
			for(int j = 0; j < 19; j++){
				if(map[i][j] > 0 && dfs(i, j)){
					System.out.println(map[i][j]);
					System.out.println((i+1) + " " + (j+1));
					return;
				}
			}
		}

		System.out.println(0);
	}

	private static boolean dfs(int x, int y){
		int color = map[x][y];

		for(int d = 0; d < 4; d++){
			// 1. 현재 위치가 이 방향의 시작점인지 확인
			int prevX = x - dir[d][0];
			int prevY = y - dir[d][1];

			if(isValid(prevX, prevY) && map[prevX][prevY] == color){
				continue; // 시작점이 아니므로 스킵
			}

			// 2. 현재 방향으로 연속된 같은 색의 바둑돌 개수 세기
			int count = 1;

			for(int i = 1; i < 5; i++){
				int nx = x + dir[d][0] * i;
				int ny = y + dir[d][1] * i;

				if(isValid(nx, ny) && color == map[nx][ny]){
					count++;
				}
				else{
					break;
				}
			}

			// 3. 정확히 5개인 경우 승리
			if(count == 5){
				int nextX = x + dir[d][0] * 5;
				int nextY = y + dir[d][1] * 5;

				if(!isValid(nextX, nextY) || color != map[nextX][nextY]) return true;
			}

		}
		return false;
	}

	private static boolean isValid(int x, int y){
		return x >= 0 && y >= 0 && x < 19 && y < 19;
	}

}