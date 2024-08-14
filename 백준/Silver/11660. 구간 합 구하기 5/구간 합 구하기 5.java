import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합 구하기 횟수
		
		int[][]map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) { // 표 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}
		
		for(int i = 0; i < M; i++) { // 구해야 하는 합 좌표 받기
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
				
			System.out.println(map[x2][y2] - map[x1-1][y2] - map[x2][y1-1] + map[x1-1][y1-1]);
		}
	}
}
