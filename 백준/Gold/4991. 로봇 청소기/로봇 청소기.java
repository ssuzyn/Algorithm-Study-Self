import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int W, H, answer;
	static char[][] room;
	static List<int[]> positions;
	static int[][] dist;
	static boolean[] dustVisited;

	// 로봇 위치를 0번 인덱스로, 먼지 위치들을 1번부터 저장
	private static void parseInput(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		if (W == 0 && H == 0) return;

		room = new char[H][W];
		positions = new ArrayList<>();

		int robotX = -1, robotY = -1;
		for (int i = 0; i < H; i++) {
			room[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (room[i][j] == 'o') {
					robotX = i;
					robotY = j;
				} else if (room[i][j] == '*') {
					positions.add(new int[]{i, j});
				}
			}
		}
		positions.add(0, new int[]{robotX, robotY});
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			parseInput(br);
			if (W == 0 && H == 0) break;

			int size = positions.size();
			dist = new int[size][size];
			for (int i = 0; i < size; i++) {
				Arrays.fill(dist[i], -1);
			}

			boolean isPossible = true;
			for (int i = 0; i < size; i++) {
				if (!bfs(i)) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				answer = Integer.MAX_VALUE;
				dustVisited = new boolean[size];
				calc(0, 1, 0);
				sb.append(answer).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void calc(int start, int count, int cost) {
		if (count == positions.size()) {
			answer = Math.min(answer, cost);
			return;
		}

		for (int i = 1; i < positions.size(); i++) {
			if (!dustVisited[i]) {
				if (dist[start][i] == -1) continue;
				dustVisited[i] = true;
				calc(i, count + 1, cost + dist[start][i]);
				dustVisited[i] = false;
			}
		}
	}

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}

	private static boolean bfs(int startIdx) {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> q = new LinkedList<>();

		int[] startPos = positions.get(startIdx);
		q.add(new int[]{startPos[0], startPos[1], 0});
		visited[startPos[0]][startPos[1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int count = cur[2];

			// 현재 위치가 다른 지점이라면 거리 기록
			for(int i = 0; i < positions.size(); i++){
				int[] p = positions.get(i);
				if(p[0] == x && p[1] == y && dist[startIdx][i] == -1){
					dist[startIdx][i] = count;
					dist[i][startIdx] = count;
				}
			}

			for (int[] d : dir) {
				int nx = x + d[0];
				int ny = y + d[1];

				if (!isValid(nx, ny) || visited[nx][ny] || room[nx][ny] == 'x') continue;

				visited[nx][ny] = true;
				q.add(new int[]{nx, ny, count + 1});
			}
		}

		// 모든 지점 간 거리가 잘 기록되었는지 확인
		for(int i = 0; i < positions.size(); i++){
			if(dist[startIdx][i] == -1) {
				// 자기 자신을 제외하고 도달할 수 없는 지점이 있다면 실패
				if(startIdx != i) return false;
			}
		}
		return true;
	}
}