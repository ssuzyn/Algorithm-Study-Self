import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			makeZero(1, 1, 0, 1, "1");
			sb.append("\n");
		}

		System.out.print(sb);
	}

	private static void makeZero(int cur, int num, int result, int op, String express) {
		if (cur == N) {
			result += (num * op);
			if(result == 0) sb.append(express).append("\n");
			return;
		}

		makeZero(cur + 1, num * 10 + (cur + 1), result, op, express + " " + Integer.toString(cur + 1));
		makeZero(cur + 1, cur + 1, result + num * op, 1, express + "+" + Integer.toString(cur + 1));
		makeZero(cur + 1, cur + 1, result + num * op, -1, express + "-" + Integer.toString(cur + 1));
	}

}
