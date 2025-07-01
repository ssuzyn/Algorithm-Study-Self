import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[] numbers = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			numbers[i] = numbers[i-1] + Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(numbers[end] - numbers[start - 1]);
			sb.append("\n");
		}

		System.out.print(sb);
	}
}