import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N-1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++){
			distance[i] = Long.parseLong(st.nextToken());
		}

		long answer = 0;
		long min = 1000000000;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++){
			long city = Long.parseLong(st.nextToken());
			min = Math.min(city, min);
			answer += min * distance[i];
		}

		System.out.println(answer);
	}
}