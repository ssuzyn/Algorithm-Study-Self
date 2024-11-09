import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	
	static int N, M, startX, startY, time;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 
	static int[][] connect = {{1, 2, 5, 6}, {1, 2, 4, 7}, {1, 3, 4, 5}, {1, 3, 6, 7}}; // 각 방향별로 연결 가능한 구조
	static int[][] struct = {{0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {2, 1}, {2, 0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 행 
			M = Integer.parseInt(st.nextToken()); // 열 
			startX = Integer.parseInt(st.nextToken()); // 출발 좌표 x
			startY = Integer.parseInt(st.nextToken()); // 출발 좌표 y
			time = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간 
			
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 1; // 시작 지점 포함 
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {startX, startY, 1});
			visited[startX][startY] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int depth = cur[2];
				
				if(depth == time) continue;
				
				int idx = map[x][y];
				for(int d : struct[idx-1]) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
					if(map[nx][ny] > 0) { // 터널이 있는 위치라면 탐색 진행 
						for(int i = 0; i < connect[d].length; i++) {
							if(map[nx][ny] == connect[d][i]) {
								q.add(new int[] {nx, ny, depth + 1});
								visited[nx][ny] = true;
								cnt++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
			
		}
	}
}