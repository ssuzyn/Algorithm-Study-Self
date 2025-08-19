import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			char[] str = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());

			// 현재 문자열의 알파벳 갯수 카운팅
			int[] alphabet = new int[26];
			for(int i = 0; i < str.length; i++){
				alphabet[str[i] - 'a']++;
			}

			int minLength = Integer.MAX_VALUE;
			int maxLength = Integer.MIN_VALUE;

			for(int i = 0; i < str.length; i++){
				char target = str[i];

				// K개 미만인 문자인 경우 pass
				if(alphabet[target - 'a'] < K) continue;

				int count = 0;
				for(int j = i; j < str.length; j++){
					if(target == str[j]) count++;
					
					// 어느 타겟 문자를 K개 포함하는 경우
					if(count == K){
						minLength = Math.min(minLength, j - i + 1);
						maxLength = Math.max(maxLength, j - i + 1);
						break;
					}
				}
			}

			if(minLength == Integer.MAX_VALUE){
				sb.append(-1).append("\n");
			}
			else{
				sb.append(minLength + " " + maxLength).append("\n");
			}
		}

		System.out.print(sb);
	}

}