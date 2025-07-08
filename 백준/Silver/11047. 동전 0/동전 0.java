import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전의 종류
		int value = Integer.parseInt(st.nextToken()); // 최종 동전 가치의 합
		int[] coin = new int[N]; // 동전의 가치

		for(int i = 0; i < N; i++){
			coin[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		for(int i = N - 1; i >= 0; i--){
			int tmp = coin[i];
			if(value >= tmp){
				answer += value / tmp;
				value = value % tmp;
			}
		}

		System.out.println(answer);
	}
}