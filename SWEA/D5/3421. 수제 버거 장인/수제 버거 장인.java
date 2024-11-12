import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, answer;
	static Set<Integer>[] notGood;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 개수
			M = Integer.parseInt(st.nextToken()); // 궁합이 맞지 않은 재료쌍
			notGood = new HashSet[N];
			selected = new boolean[N];
			answer = 1;

			for (int i = 0; i < N; i++) {
				notGood[i] = new HashSet<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				notGood[a].add(b);
				notGood[b].add(a);
			}

			part(0, 0);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.print(sb);
	}

	private static void part(int idx, int cnt) {
		if (idx == N) { // 모든 재료에 대해 선택 여부 결정 완료
			if (cnt > 0 && isValid()) { // 재료가 하나 이상 선택되었고 조합이 유효한 경우
				answer++;
			}
			return;
		}

		// 현재 재료를 선택
		selected[idx] = true;
		part(idx + 1, cnt + 1);

		// 현재 재료를 선택하지 않음
		selected[idx] = false;
		part(idx + 1, cnt);
	}

	private static boolean isValid() {
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				for (int not : notGood[i]) {
					if (selected[not]) { // 선택된 재료 중 궁합이 맞지 않는 쌍이 있는지 확인
						return false;
					}
				}
			}
		}
		return true;
	}

}
