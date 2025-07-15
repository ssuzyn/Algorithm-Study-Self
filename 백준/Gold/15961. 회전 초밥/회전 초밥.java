import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] sushiBelt = new int[N];
		int[] sushiType = new int[d + 1];

		for(int i = 0; i < N; i++){
			sushiBelt[i] = Integer.parseInt(br.readLine());
		}

		// 초기 윈도우 설정
		int count = 0;
		for(int i = 0; i < k; i++){
			int sushiNum = sushiBelt[i];
			if(sushiType[sushiNum] == 0) count++;
			sushiType[sushiNum]++;
		}

		// 쿠폰 초밥 추가 (아직 없다면)
		if(sushiType[c] == 0) count++;
		sushiType[c]++;

		int maxCnt = count;

		// 슬라이딩 윈도우로 회전
		for(int i = 0; i < N; i++){
			// 왼쪽 끝 제거
			int leftSushi = sushiBelt[i];
			sushiType[leftSushi]--;
			if(sushiType[leftSushi] == 0) count--;

			// 오른쪽 끝 추가
			int rightSushi = sushiBelt[(i + k) % N];
			if(sushiType[rightSushi] == 0) count++;
			sushiType[rightSushi]++;

			maxCnt = Math.max(count, maxCnt);
		}

		System.out.println(maxCnt);
	}
}