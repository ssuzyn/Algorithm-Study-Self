import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] snow = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snow);

		int minDiff = Integer.MAX_VALUE;

		// 첫 번째 눈사람을 만드는 모든 경우
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int snowElsa = snow[i] + snow[j];

				// 남은 눈덩이들로 두 번째 눈사람 만들기 (투 포인터)
				int left = 0;
				int right = N - 1;

				while (left < right) {
					// 이미 사용된 인덱스 건너뛰기
					if (left == i || left == j) {
						left++;
						continue;
					}
					if (right == i || right == j) {
						right--;
						continue;
					}

					int snowAnna = snow[left] + snow[right];
					minDiff = Math.min(minDiff, Math.abs(snowElsa - snowAnna));

					// 최적해 발견시 조기 종료
					if (minDiff == 0) {
						System.out.println(0);
						return;
					}

					// 투 포인터 이동
					if (snowAnna < snowElsa) {
						left++;
					} else {
						right--;
					}
				}
			}
		}

		System.out.println(minDiff);
	}
}