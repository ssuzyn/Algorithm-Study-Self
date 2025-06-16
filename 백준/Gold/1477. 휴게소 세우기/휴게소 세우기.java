import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, L;
	static int[] restArea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 휴게소의 개수
		M = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소의 개수
		L = Integer.parseInt(st.nextToken()); // 고속도로 길이

		restArea = new int[N + 2]; // 휴게소 위치 리스트
		restArea[0] = 0;
		restArea[N + 1] = L;

		if(N > 0){
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++){
				restArea[i] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(restArea); // 휴게소 위치 오름차순 정렬

		int left = 1;
		int right = L - 1;
		int answer = right;

		while(left <= right){
			int mid = (left + right) / 2;

			// mid를 최대구간으로 했을 때 필요한 휴게소 개수
			int maxDist = calculateNeeded(mid);

			if(maxDist <= M){
				answer = mid;
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

	private static int calculateNeeded(int maxDist){
		int count = 0;

		for(int i = 1; i < restArea.length; i++){
			int dist = restArea[i] - restArea[i - 1];

			if(dist > maxDist){
				count += (dist - 1) / maxDist; // 구간을 maxDist 이하로 나누는데 필요한 휴게소 개수
			}
		}
		return count;
	}

}
