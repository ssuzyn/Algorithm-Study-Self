import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int[] numbers;
	static int[] picked;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true){
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			if(K==0){
				System.out.println(sb);
				return;
			}

			numbers = new int[K];
			picked = new int[K];
			for(int i = 0; i < K; i++){
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			lotto(0, 0);
			sb.append("\n");
		}
	}

	private static void lotto(int cnt, int start){
		if(cnt == 6){
			for(int i = 0; i < 6; i++){
				sb.append(picked[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i = start; i < K; i++){
			picked[cnt] = numbers[i];
			lotto(cnt + 1, i + 1);
		}
	}

}