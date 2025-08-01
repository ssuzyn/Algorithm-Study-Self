import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, time = 0, notTomato = 0;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		box = new int[N][M];

		Queue<int[]> tomato = new LinkedList<>();

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) tomato.add(new int[]{i, j, 0});

				if(box[i][j] == 0) notTomato++;
			}
		}

		bfs(tomato);
		System.out.println(notTomato == 0? time : -1);
	}

	private static void bfs(Queue<int[]> tomato){
		Queue<int[]> nextTomato = new LinkedList<>();

		while(!tomato.isEmpty()){
			int[] cur = tomato.poll();
			int x = cur[0];
			int y = cur[1];

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(box[nx][ny] == 0){
					notTomato--;
					box[nx][ny] = 1;
					nextTomato.add(new int[]{nx, ny});
				}
			}
		}

		if(!nextTomato.isEmpty()) {
			time++;
			bfs(nextTomato);
		}
	}
}