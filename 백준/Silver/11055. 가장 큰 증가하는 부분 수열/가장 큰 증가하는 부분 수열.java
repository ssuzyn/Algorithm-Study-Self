import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++){
			sum[i] = arr[i];
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					sum[i] = Math.max(sum[i], sum[j] + arr[i]);
				}
			}
		}

		int answer = 0;
		for(int i = 0; i < N; i++){
			answer = Math.max(answer, sum[i]);
		}

		System.out.println(answer);

	}

}