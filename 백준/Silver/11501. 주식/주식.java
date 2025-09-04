import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[] value = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++){
				value[i] = Integer.parseInt(st.nextToken());
			}

			long profit = 0;
			int max = 0;
			for(int i = N-1; i >= 0; i--){
				if(max > value[i]){
					profit += max - value[i];
				}
				else max = value[i];
			}

			sb.append(profit).append("\n");
		}

		System.out.println(sb);
	}
}