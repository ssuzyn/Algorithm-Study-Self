import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer;
	static int endX, endY;
	static int[][] swimming;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 수영장 크기
			swimming = new int[N][N];
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					swimming[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			answer = bfs(startX, startY);
			
			System.out.println("#" + t + " " + answer);
		}

	}
	
	static int bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY, 0}); // 시작점과 초기 depth(거리)를 큐에 추가
		visit[startX][startY] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int depth = current[2];
			
			// 도착지점에 도착하면 해당 경로의 길이를 반환
			if (x == endX && y == endY) {
				return depth;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
				
				if (swimming[nx][ny] == 0) {
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny, depth + 1});
				}
			}
		}
		
		return -1; // 도착지점에 도달할 수 없는 경우
	}

}
