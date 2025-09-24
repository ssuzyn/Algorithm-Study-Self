import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;       // 원래 기둥 배열
	static int[] dpLeft;    // 왼쪽에서 감소 수열 길이
	static int[] dpRight;   // 오른쪽에서 감소 수열 길이
	static boolean[] checkLeft;
	static boolean[] checkRight;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dpLeft = new int[N];
		dpRight = new int[N];
		checkLeft = new boolean[N];
		checkRight = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dpLeft[i] = dpRight[i] = 1; // 최소 길이 1
		}
	}

	static void solve() {
		// 왼쪽에서 감소 DP 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
					if (dpLeft[i] < dpLeft[j] + 1) {
						checkLeft[i] = true;
					}
				}
			}
		}

		// 오른쪽에서 감소 DP 계산
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (arr[i] < arr[j]) {
					dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
					if (dpRight[i] < dpRight[j] + 1) {
						checkRight[i] = true;
					}
				}
			}
		}

		// 교차점 기준 최대 길이 계산
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int left = dpLeft[i];
			int right = dpRight[i];
			if (checkLeft[i] && checkRight[i]) {
				answer = Math.max(answer, left + right - 1);
			} else {
				answer = Math.max(answer, left + right);
			}
		}

		System.out.println(answer - 1); // 마지막 중복 제거
	}
}
