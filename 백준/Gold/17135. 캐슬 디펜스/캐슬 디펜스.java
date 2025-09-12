import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, maxKill;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한
		map = new int[N][M];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxKill = 0;
		combiArcher(0, 0, new int[3]);
		System.out.println(maxKill);
	}

	private static int[][] copyMap(int[][] map){
		int[][] newMap = new int[N][M];
		for(int i = 0; i < N; i++){
			newMap[i] = map[i].clone();
		}
		return newMap;
	}

	private static void combiArcher(int start, int cnt, int[] number){
		if(cnt == 3){
			castleDefence(number);
			return;
		}

		for(int i = start; i < M; i++){
			number[cnt] = i;
			combiArcher(i + 1, cnt + 1, number);
		}
	}

	private static void castleDefence(int[] archers){
		int[][] newMap = copyMap(map);
		int killCount = 0;
		int castleRow = N;

		while(castleRow > 0){
			boolean[][] target = new boolean[N][M];

			for(int a = 0; a < 3; a++){
				int ax = castleRow;
				int ay = archers[a];
				int tx = -1;
				int ty = -1;
				int minDist = Integer.MAX_VALUE;

				// 궁수 위치에서 가장 가까운 적 찾기
				for(int i = castleRow - 1; i >= 0; i--){
					for(int j = 0; j < M; j++){
						if(newMap[i][j] == 1){
							int dist = Math.abs(ax - i) + Math.abs(ay - j);
							if (dist <= D){
								if (dist < minDist || (dist == minDist && j < ty)) {
									minDist = dist;
									tx = i;
									ty = j;
								}
							}
						}
					}
				}

				if(minDist != Integer.MAX_VALUE){
					target[tx][ty] = true;
				}
			}

			castleRow--;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (target[i][j] && newMap[i][j] == 1) {
						newMap[i][j] = 0;
						killCount++;
					}
				}
			}

		}
		maxKill = Math.max(maxKill, killCount);
	}

}
