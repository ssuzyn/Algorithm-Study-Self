import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전체 사람 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> pos = new ArrayList<>(); // 양수 발언
		ArrayList<Integer> neg = new ArrayList<>(); // 음수 발언

		for(int i = 0; i < N; i++){
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp > 0) pos.add(tmp);
			else neg.add(tmp);
		}

		Collections.sort(pos);
		Collections.sort(neg);

		int answer = 0;
		StringBuilder sb = new StringBuilder();

		// 가능한 거짓말쟁이 수(lier)를 0부터 N까지 가정하며 확인
		for(int lier = 0; lier <= N; lier++){
			int realLier = 0;

			realLier += pos.size() - binarySearch(pos, lier); // 양수: lier보다 큰 값을 말한 사람들이 거짓말쟁이
			realLier += neg.size() - binarySearch(neg, -lier); // 음수: -lier보다 큰 값을 말한 사람들이 거짓말쟁이

			// 실제 거짓말쟁이 수가 가정한 수와 같다면 가능한 경우
			if(realLier == lier){
				answer++;
				sb.append(lier).append(" ");
			}
		}

		System.out.println(answer);
		System.out.println(sb);
	}

	// person 리스트에서 lier보다 큰 값이 처음 나오는 위치(인덱스)를 반환
	private static int binarySearch(ArrayList<Integer> person, int lier){
		int left = 0;
		int right = person.size();

		while(left < right){
			int mid = (left + right) / 2;

			if(person.get(mid) <= lier) left = mid + 1;
			else right = mid;
		}
		return left;
	}
}
