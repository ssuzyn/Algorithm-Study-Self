import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int white, blue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		white = 0; blue = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void divide(int x, int y, int size) {
		int sum = 0;
		
		for(int r = x, rEnd = x + size; r < rEnd; r++) {
			for(int c = y, cEnd = y + size; c < cEnd; c++) {
				sum += map[r][c];
			}
		}
		
		if(sum == 0) { // 흰색으로만 이루어진 사각형
			white++;
		}
		else if(sum == size * size) { // 파란색으로만 이루어진 사각형
			blue++;
		}
		else {
			int half = size / 2;
			divide(x, y, half);
			divide(x, y + half, half);
			divide(x + half, y, half);
			divide(x + half, y + half, half);
		}
	}

}
