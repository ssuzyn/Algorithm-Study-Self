import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static char [][] map;
	static int N;
	static int maxCandy = 1;

	private static void swap(int x1, int y1, int x2, int y2) {
		char tmp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = tmp;
	}
	
	
	private static void search() {
		
		// 행 기준으로 연속된 문자 탐색
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N - 1; j++) {
				if(map[i][j] == map[i][j+1]) {
					count++;
					maxCandy = Math.max(count, maxCandy);
				}
				else count = 1;
			}
		}
		
		// 열 기준으로 연속된 문자 탐색
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N - 1; j++) {
				if(map[j][i] == map[j+1][i]) {
					count++;
					maxCandy = Math.max(count, maxCandy);
				}
				else count = 1;
			}
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				swap(i, j, i, j + 1);
				search();
				swap(i, j, i, j + 1);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				swap(j, i, j + 1, i);
				search();
				swap(j, i, j + 1, i);
			}
		}
		
		System.out.println(maxCandy);
		
	}

}
