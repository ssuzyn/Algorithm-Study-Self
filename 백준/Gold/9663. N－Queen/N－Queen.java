import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] queen;
	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		queen = new int[N + 1];
		answer = 0;
		setQueen(1);
		System.out.println(answer);
	}

	private static void setQueen(int idx){
		if(!isAvailable(idx - 1)) return;

		if(idx > N){
			answer++;
			return;
		}

		for(int i = 1; i <= N; i++){
			queen[idx] = i;
			setQueen(idx + 1);
		}
	}

	private static boolean isAvailable(int rowNum){
		for(int i = 1; i < rowNum; i++){

			// 같은 열에 있거나 대각선에 있으면 안된다.
			if(queen[i] == queen[rowNum]
				|| rowNum - i == Math.abs(queen[i] - queen[rowNum]))
				return false;
		}
		return true;
	}
}
