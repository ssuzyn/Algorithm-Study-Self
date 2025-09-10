import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int N, C;
	static int[] home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집
		C = Integer.parseInt(st.nextToken()); // 공유기
		home = new int[N];

		for(int i = 0; i < N; i++){
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		int answer = 0;
		int left = 1; // 최소 가능한 거리
		int right = home[N-1] - home[0]; // 최대 가능한 거리

		while(left <= right){
			int mid = (left + right) / 2;

			if(settingRouter(mid) >= C){
				answer = mid;
				left = mid + 1;
			}
			else right = mid - 1;
		}

		System.out.println(answer);
	}

	private static int settingRouter(int distance){
		int count = 1;
		int lastInstalled = home[0];

		for(int i = 1; i < N; i++){
			if(home[i] - lastInstalled >= distance){
				count++;
				lastInstalled = home[i];
			}
		}

		return count;
	}
}