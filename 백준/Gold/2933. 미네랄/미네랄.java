import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static char[][] map;
	static HashSet<Point> mineral;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

	static class Point{
		int x; int y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode(){
			return Objects.hash(x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];
			}
		}

		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int t = 0; t < T; t++){
			int height = Integer.parseInt(st.nextToken());
			throwStick(N - height, t % 2 == 0);

			checkAndMoveCluster();
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void checkAndMoveCluster(){
		boolean[][] visited = new boolean[N][M];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(map[i][j] == 'x' && !visited[i][j]){
					mineral = new HashSet<>();

					if(!checkCluster(i, j, visited)){
						moveCluster();
						return;
					}
				}
			}
		}
	}

	private static void moveCluster(){
		int height = 100;
		Iterator<Point> iter = mineral.iterator();

		while(iter.hasNext()){
			Point cur = iter.next();
			int x = cur.x;
			int y = cur.y;
			map[x][y] = '.';

			for(int h = x + 1; h < N; h++){
				if(map[h][y] == 'x' && !mineral.contains(new Point(h, y))){
					height = Math.min(height, h - x - 1); // 다른 미네랄과 부딪히기 직전 위치
					break;
				}
			}

			height = Math.min(height, N - x - 1); // 다른 미네랄이 없는 경우, 바닥과의 거리
		}

		iter = mineral.iterator();
		while(iter.hasNext()){
			Point cur = iter.next();
			map[cur.x + height][cur.y] = 'x';
		}
	}

	private static boolean checkCluster(int x, int y, boolean[][] visited){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		mineral.add(new Point(x, y));

		visited[x][y] = true;
		boolean isConnectedWithBottom = false;

		while(!q.isEmpty()){
			Point cur = q.poll();

			if(cur.x == N-1) isConnectedWithBottom = true;

			for(int[] d : dir){
				int nx = cur.x + d[0];
				int ny = cur.y + d[1];

				if(!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] != 'x') continue;

				visited[nx][ny] = true;
				mineral.add(new Point(nx, ny));
				q.add(new Point(nx, ny));
			}
		}

		return isConnectedWithBottom;
	}

	private static boolean isValid(int x, int y){
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	private static void throwStick(int idx, boolean isLeft){
		if(isLeft){
			for(int i = 0; i < M; i++){
				if(map[idx][i] == 'x'){
					map[idx][i] = '.';
					return;
				}
			}
		}
		else{
			for(int i = M-1; i >= 0; i--){
				if(map[idx][i] == 'x'){
					map[idx][i] = '.';
					return;
				}
			}
		}
	}

}
