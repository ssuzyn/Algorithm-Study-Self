import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[] ball;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ball = br.readLine().toCharArray();

		int countR = 0;
		int countB = 0;
		for(int i = 0; i < N; i++){
			if(ball[i] == 'R') countR++;
			else countB++;
		}

		// 4가지 케이스 각각 계산
		int case1 = countR - moveLeft('R');   // 빨간볼 왼쪽으로
		int case2 = countR - moveRight('R');  // 빨간볼 오른쪽으로
		int case3 = countB - moveLeft('B');   // 파란볼 왼쪽으로
		int case4 = countB - moveRight('B');  // 파란볼 오른쪽으로

		// 4개 중 최솟값
		int answer = Math.min(Math.min(case1, case2), Math.min(case3, case4));
		System.out.println(answer);
	}

	private static int moveLeft(char color){
		int count = 0;
		for(int i = 0; i < N; i++){
			if(ball[i] == color) count++;
			else break;
		}

		return count;
	}

	private static int moveRight(char color){
		int count = 0;
		for(int i = N-1; i >= 0; i--){
			if(ball[i] == color) count++;
			else break;
		}

		return count;
	}
}