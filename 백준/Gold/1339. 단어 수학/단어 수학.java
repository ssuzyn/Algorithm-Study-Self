import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				alpha[str.charAt(j) - 'A'] += (int)Math.pow(10, str.length() - j - 1);
			}
		}
		
		Arrays.sort(alpha);
		
		int sum = 0;
		int idx = 25;
		int num = 9;
		while(alpha[idx] > 0) {
			sum += alpha[idx] * num;
			idx--;
			num--;
		}
		
		System.out.println(sum);
	}

}
