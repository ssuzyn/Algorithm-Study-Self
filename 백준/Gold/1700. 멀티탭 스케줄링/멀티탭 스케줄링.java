import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] scheduler;
	static List<Integer> flug;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
		K = Integer.parseInt(st.nextToken()); // 사용 횟수
		scheduler = new int[K];
		flug = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++){
			scheduler[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for(int i = 0; i < K; i++){
			if(flug.contains(scheduler[i])) continue;

			if(flug.size() < N){
				// 빈자리가 있으면 그냥 꽂기
				flug.add(scheduler[i]);
			}
			else{
				// 현재 기기가 이미 꽂혀있으면 skip
				exchangePosition(i);
				flug.add(scheduler[i]);
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static void exchangePosition(int start) {
		int removeIdx = 0;
		int farthest = start;

		// 콘센트에 꽂힌 각 기기별로 다음 사용 시점 찾기
		for(int i = 0; i < flug.size(); i++) {
			int nextUse = Integer.MAX_VALUE; // 사용되지 않으면 최대값

			// start부터 뒤를 보면서 이 기기가 언제 나오는지 찾기
			for(int j = start; j < K; j++) {
				if(scheduler[j] == flug.get(i)) {
					nextUse = j;
					break;
				}
			}

			// 가장 늦게 사용되는(또는 사용되지 않는) 기기 찾기
			if(nextUse > farthest) {
				farthest = nextUse;
				removeIdx = i;
			}
		}

		flug.remove(removeIdx);
	}
}