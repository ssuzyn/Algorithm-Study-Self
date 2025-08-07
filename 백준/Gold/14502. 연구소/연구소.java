import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, maxSafe = 0;
	static int[][] originMap;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		originMap = new int[N][M];
		List<int[]> empty = new ArrayList<>();
		List<int[]> virus = new ArrayList<>();

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				originMap[i][j] = Integer.parseInt(st.nextToken());
				if(originMap[i][j] == 2) virus.add(new int[]{i, j});
				if(originMap[i][j] == 0) empty.add(new int[]{i, j});
			}
		}

		for(int i = 0; i < empty.size() - 2; i++){
			for(int j = i + 1; j < empty.size() - 1; j++){
				for(int k = j + 1; k < empty.size(); k++){
					int[][] map = initMap();
					map[empty.get(i)[0]][empty.get(i)[1]] = 1;
					map[empty.get(j)[0]][empty.get(j)[1]] = 1;
					map[empty.get(k)[0]][empty.get(k)[1]] = 1;
					bfs(virus, map);
					maxSafe = Math.max(maxSafe, getSafeArea(map));
				}
			}
		}

		System.out.println(maxSafe);
	}

	private static int[][] initMap(){
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++){
			map[i] = originMap[i].clone();
		}

		return map;
	}

	private static void bfs(List<int[]> virus, int[][] map){
		Queue<int[]> q = new LinkedList<>(virus);

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for(int[] d : dir){
				int nx = x + d[0];
				int ny = y + d[1];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(map[nx][ny] == 0){
					map[nx][ny] = 2;
					q.add(new int[]{nx, ny});
				}
			}
		}
	}

	private static int getSafeArea(int[][] map){
		int cnt = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(map[i][j] == 0) cnt++;
			}
		}

		return cnt;
	}

}