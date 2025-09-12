import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

class Shortcut {
	int start, end, length;

	Shortcut(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 지름길 개수
		int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

		List<Shortcut> shortcuts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			if (end <= D && length < end - start) {
				shortcuts.add(new Shortcut(start, end, length));
			}
		}

		int[] dp = new int[D + 1];
		for (int i = 0; i <= D; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;

		for (int i = 1; i <= D; i++) {
			// 직선 도로를 따라 한 칸 이동
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			// 지름길 적용
			for (Shortcut sc : shortcuts) {
				if (sc.end == i && dp[sc.start] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[sc.start] + sc.length);
				}
			}
		}

		System.out.println(dp[D]);
	}
}
