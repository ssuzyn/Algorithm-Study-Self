import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String vowels = "aeiou";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			String word = br.readLine();
			if(word.equals("end")){
				System.out.print(sb);
				return;
			}

			boolean flag = false;
			int count = 0;
			char[] words = word.toCharArray();

			for (int i = 0; i < words.length; i++) {
				// 1. 모음이 하나라도 등장했는지 체크
				if (isVowel(words[i])) flag = true;

				// 2. 연속된 모음/자음 개수 세기
				if (i > 0 && isVowel(words[i]) != isVowel(words[i - 1])) count = 1;
				else count++;

				// 3. 같은 종류(모음/자음)가 3번 연속 나오면 불가능 or 같은 글자가 두 번 연속 나오면 불가능
				if (count > 2 || i > 0 && words[i] == words[i - 1] && words[i] != 'e' && words[i] != 'o') {
					flag = false;
					break;
				}
			}


			sb.append('<').append(word).append('>');
			if(flag) sb.append(" is acceptable.\n");
			else sb.append(" is not acceptable.\n");
		}

	}

	private static boolean isVowel(char w){
		return vowels.contains(String.valueOf(w));
	}

}