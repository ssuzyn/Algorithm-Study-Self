import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N;
	static char[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	static class Node{
		int x, y;
		int d;
		int mirror;

		Node(int x, int y, int d, int mirror){
			this.x = x;
			this.y = y;
			this.d = d;
			this.mirror = mirror;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		int[][] doors = new int[2][2];
		int doorCount = 0;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '#') {
					doors[doorCount][0] = i;
					doors[doorCount][1] = j;
					doorCount++;
				}
			}
		}

		dijkstra(doors[0][0], doors[0][1], doors[1][0], doors[1][1]);
	}

	private static void dijkstra(int startX, int startY, int endX, int endY){
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.mirror - n2.mirror);
		boolean[][][] visited = new boolean[N][N][4];

		// 시작 위치에서 탐색할 수 있는 방향 추가
		for(int i = 0; i < 4; i++){
			pq.offer(new Node(startX, startY, i, 0));
		}

		while(!pq.isEmpty()){
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			int d = node.d;
			int mirror = node.mirror;

			if(visited[x][y][d]) continue;
			visited[x][y][d] = true;

			if(x == endX && y == endY){
				System.out.println(mirror);
				return;
			}

			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(!isValid(nx, ny) || visited[nx][ny][d] || map[nx][ny] == '*') continue;

			// 거울 설치 가능한 위치인 경우
			if(map[nx][ny] == '!'){
				pq.offer(new Node(nx, ny, (d + 1) % 4, mirror + 1));
				pq.offer(new Node(nx, ny, (d + 3) % 4, mirror + 1));
			}
			pq.offer(new Node(nx, ny, d, mirror));
		}

	}

	private static boolean isValid(int x, int y){
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}
