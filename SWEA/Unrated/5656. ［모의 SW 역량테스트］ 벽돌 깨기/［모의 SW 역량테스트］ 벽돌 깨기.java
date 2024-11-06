import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H;
	static int totalOfBrick, count, result;
	static int[][] origin, map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			origin = new int[H][W];
			map = new int[H][W];
			result = 0; // 최대로 제거할 수 있는 벽돌의 개수
			totalOfBrick = 0; // 총 벽돌 개수

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					origin[i][j] = Integer.parseInt(st.nextToken());
					if (origin[i][j] > 0)
						totalOfBrick++;
				}
			}

			pickTurn(new int[N], 0);
			System.out.println("#" + t + " " + (totalOfBrick - result));
		}
	}

	// 1. 재귀를 이용한 중복 순열 구성하기
	private static void pickTurn(int[] turn, int cnt) {
		if (cnt == N) {
			shooting(turn);
			return;
		}

		for (int i = 0; i < W; i++) {
			turn[cnt] = i;
			pickTurn(turn, cnt + 1);
		}
	}

	// 2. 구슬 떨어트리기
	private static void shooting(int[] turn) {
		count = 0;
		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = origin[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][turn[i]] != 0) {
					destroy(j, turn[i]);
					break;
				}
			}
			fillEmptySpace();
		}
		result = Math.max(result, count);
	}

	// 3. 벽 연쇄 파괴하기
	private static void destroy(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, map[x][y] });
		map[x][y] = 0;
		count++; // 파괴한 벽 개수 세기

		while (!queue.isEmpty()) {
			int[] brick = queue.poll();
			x = brick[0];
			y = brick[1];
			int bound = brick[2];
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < bound; j++) {
					int nx = x + dir[i][0] * j;
					int ny = y + dir[i][1] * j;

					if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if (map[nx][ny] != 0){
						queue.add(new int[] {nx, ny, map[nx][ny]});
						map[nx][ny] = 0;
						count++;
					}
				}
			}
		}

	}

	// 4. 공백 채우기
	private static void fillEmptySpace() {

		for (int y = 0; y < W; y++) {
			Stack<Integer> stack = new Stack<>();
			for (int x = 0; x < H; x++) {
				if (map[x][y] != 0) {
					stack.add(map[x][y]);
					map[x][y] = 0;
				}
			}

			int row = H - 1;
			while (!stack.isEmpty()) {
				map[row--][y] = stack.pop();
			}
		}
	}

}
