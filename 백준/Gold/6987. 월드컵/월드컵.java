import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	static int[][] play = new int[6][3]; // 경기 정보 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				play[j / 3][j % 3] = Integer.parseInt(st.nextToken());
			}

			answer = 0;
			boolean flag = false;
			for (int j = 0; j < 6; j++) {
				if (play[j][0] + play[j][1] + play[j][2] != 5) {
					flag = true;
					break;
				}
			}
			if (flag) {
				sb.append(answer + " ");
				continue;
			}
			
			dfs(0, 1);
			sb.append(answer + " ");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int cur, int next) {
		
		if(answer == 1) return;
		
		if(cur == 5 && next == 6) {
			if(check()) {
				answer = 1;
				return;
			}
		}
		
		if(next > 5 && cur < 5) {
			cur++;
			next = cur + 1;
			dfs(cur, next);
		}

		if (play[cur][0] > 0 && play[next][2] > 0) { // 승 - 패
			play[cur][0]--;
			play[next][2]--;
			dfs(cur, next + 1);
			play[cur][0]++;
			play[next][2]++;
		}

		if (play[cur][1] > 0 && play[next][1] > 0) { // 무 - 무
			play[cur][1]--;
			play[next][1]--;
			dfs(cur, next + 1);
			play[cur][1]++;
			play[next][1]++;
		}

		if (play[cur][2] > 0 && play[next][0] > 0) { // 승 - 패
			play[cur][2]--;
			play[next][0]--;
			dfs(cur, next + 1);
			play[cur][2]++;
			play[next][0]++;
		}
		

	}

	private static boolean check() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (play[i][j] != 0)
					return false;
			}
		}
		return true;
	}

}
