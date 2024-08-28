import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] tomato;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> Q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행
        tomato = new int[M][N];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		tomato[i][j] = Integer.parseInt(st.nextToken());
        		if(tomato[i][j] == 1) Q.add(new int[] {i, j}); // 익은 토마토만 큐에 넣기
        	}
        }
        
        bfs();
        
        int day = 0;
        for(int i = 0; i < M; i++) {
        	for(int j = 0; j < N; j++) {
        		if(tomato[i][j] == 0) {
        			System.out.println(-1);
        			return;
        		}
        		if(tomato[i][j] > day) {
        			day = tomato[i][j];
        		}
        	}
        }
        
        System.out.println(day-1);
	}
	
	
	static void bfs() {
		
		while(!Q.isEmpty()) {
			int[] tmp = Q.poll();
			
			int x = tmp[0];
			int y = tmp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N && tomato[nx][ny] == 0) {
					tomato[nx][ny] = tomato[x][y] + 1;
					Q.add(new int[] {nx, ny});
				}
			}
		}
	}

}
