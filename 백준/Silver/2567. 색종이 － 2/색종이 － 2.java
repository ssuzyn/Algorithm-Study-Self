import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] board = new boolean[102][102];
		int answer = 0;

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					board[j][k] = true;
				}
			}
		}


		// 세로 경계선 카운팅 (열 기준)
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				// 0->1 또는 1->0으로 변하는 지점이 경계선
				if(board[i][j] != board[i][j+1]) answer++;
			}
		}

		// 가로 경계선 카운팅 (행 기준)
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				// 0->1 또는 1->0으로 변하는 지점이 경계선
				if(board[i][j] != board[i+1][j]) answer++;
			}
		}

		System.out.println(answer);
	}

}