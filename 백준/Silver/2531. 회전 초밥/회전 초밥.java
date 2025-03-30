import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 초밥 총 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] sushi = new int[N];
		int[] num = new int[d + 1];

		for(int i = 0; i < N; i++){
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int start = 0;
		int end = k-1;
		int count = 0;
		int answer = 0;

		for(int i = start; i <= end; i++){
			if(num[sushi[i]] == 0) count++;
			num[sushi[i]]++;
		}

		while(true){

			if(num[c] == 0) answer = Math.max(answer, count + 1);
			answer = Math.max(answer, count);

			if(num[sushi[start]] == 1) count--;
			num[sushi[start]] -= 1;

			start = (start + 1) % N;
			end = (end + 1) % N;

			if(start == 0) break;

			if(num[sushi[end]] == 0) count++;
			num[sushi[end]] += 1;
		}
		System.out.println(answer);

	}
}
