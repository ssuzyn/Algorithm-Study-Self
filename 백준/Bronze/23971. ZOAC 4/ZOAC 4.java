import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 세로 방향으로 앉을 수 있는 사람 수
		// 첫 번째 사람이 (0,0)에 앉으면, 다음 사람은 (N+1,0)에 앉을 수 있음
		int rowCount = (H + N) / (N + 1);

		// 가로 방향으로 앉을 수 있는 사람 수
		// 첫 번째 사람이 (0,0)에 앉으면, 다음 사람은 (0,M+1)에 앉을 수 있음
		int colCount = (W + M) / (M + 1);

		System.out.println(rowCount * colCount);
	}
}