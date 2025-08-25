import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String currentStr = br.readLine();
		String targetStr = br.readLine();

		int[] current = new int[N];
		int[] target = new int[N];

		for(int i = 0; i < N; i++) {
			current[i] = currentStr.charAt(i) - '0';
			target[i] = targetStr.charAt(i) - '0';
		}

		// 경우 1: 0번 스위치를 누르지 않는 경우
		int case1 = solve(current.clone(), target, 0);


		// 경우 2: 0번 스위치를 누르는 경우
		int[] arr = current.clone();
		toggle(arr, 0);
		int case2 = solve(arr, target, 1);

		int result = Math.min(case1, case2);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static int solve(int[] current, int[] target, int count) {
		for(int i = 1; i < N; i++) {
			// i-1번째 전구가 목표와 다르면 i번째 스위치를 눌러야 함
			if(current[i-1] != target[i-1]) {
				toggle(current, i);
				count++;
			}
		}

		// 마지막 전구도 목표와 같은지 확인
		if(current[N-1] != target[N-1]) {
			return Integer.MAX_VALUE;
		}

		return count;
	}

	private static void toggle(int[] arr, int i) {
		if(i > 0) arr[i-1] = 1 - arr[i-1];
		arr[i] = 1 - arr[i];
		if(i < N-1) arr[i+1] = 1 - arr[i+1];
	}
}