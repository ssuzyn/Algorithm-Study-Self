import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N-1;
		int minSum = Integer.MAX_VALUE;
		while(left < right){
			int sum = liquid[left] + liquid[right];

			if(Math.abs(sum) < Math.abs(minSum)) minSum = sum;

			if(sum < 0) left++;
			else right--;
		}

		System.out.println(minSum);
	}

}