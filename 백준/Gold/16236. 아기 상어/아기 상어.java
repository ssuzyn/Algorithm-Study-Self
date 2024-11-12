import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, full, time;
	static int[][] map;
	static Fish baby;
	
	static class Fish implements Comparable<Fish>{
		int x, y, size, time;
		
		Fish(int x, int y, int size, int time){
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.time != o.time) return this.time - o.time;
			else {
				if(this.x != o.x) {
					return this.x - o.x; // 가장 위에 있는 물고기 
				}
				return this.y - o.y;  // x좌표가 같다면 가장 왼쪽에 있는 물고기 
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 맵 크기 
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
				 if(map[i][j] == 9) {
					 map[i][j] = 0;
					 baby = new Fish(i, j, 2, 0);
				 }
			}
		}
		
		full = 0;
		time = 0;
		while(true) {
			if(!eatBabyFish()) break;
		}
		
		System.out.println(time);
	}
	
	private static boolean eatBabyFish() {
		boolean[][] visited = new boolean[N][N];
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		Queue<int[]> fishQ = new LinkedList<>();
		PriorityQueue<Fish> canEat = new PriorityQueue<>();
		
		fishQ.add(new int[] {baby.x, baby.y, 0});
		visited[baby.x][baby.y] = true;
		
		while(!fishQ.isEmpty()) {
			int[] cur = fishQ.poll();
			int x = cur[0];
			int y = cur[1];
			int depth = cur[2];
			
			if(0 < map[x][y] && map[x][y] < baby.size) {
				canEat.add(new Fish(x, y, map[x][y], depth));
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				if(map[nx][ny] > baby.size) continue;
				visited[nx][ny] = true;
				fishQ.add(new int[] {nx, ny, depth+1});
			}
		}
		
		if(canEat.isEmpty()) return false;
		
		Fish fish = canEat.poll();
		full++;
		baby.x = fish.x;
		baby.y = fish.y;
		time += fish.time;
		map[fish.x][fish.y] = 0;
		
		if(full == baby.size) {
			baby.size++;
			full = 0;
		}
		return true;
		
	}
}
