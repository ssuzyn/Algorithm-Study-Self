import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;
		for(int i = 0; i < N; i++){
			int left = 0;
			int right = N-1;
			int target = arr[i];

			while(left < right){
				// target은 다른 수 두개의 합으로 나타낼 수 있다.
				if(i == left) {
					left++;
					continue;
				}
				else if(i == right) {
					right--;
					continue;
				}

				int sum = arr[left] + arr[right];
				if(sum == target){
					count++;
					break;
				}

				if(sum < target) left++;
				else right--;
			}
		}

		System.out.println(count);
	}
}