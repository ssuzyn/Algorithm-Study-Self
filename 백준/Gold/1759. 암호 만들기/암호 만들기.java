import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static String vowels = "aeiou";
	static String[] alpha;
	static String[] password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 암호 글자수
		C = Integer.parseInt(st.nextToken()); // 문자의 종류
		alpha = br.readLine().split(" ");
		password = new String[L];

		Arrays.sort(alpha);
		dfs(0, 0, 0, 0);
	}

	static void dfs(int cnt, int idx, int vowel, int consonant){
		if(cnt == L){
			if(vowel >= 1 && consonant >= 2){
				for(String word : password){
					System.out.print(word);
				}
				System.out.println();
			}
			return;
		}

		for(int i = idx; i < C; i++){
			password[cnt] = alpha[i];

			int nextVowel = vowel;
			int nextConsonant = consonant;

			if(vowels.contains(alpha[i])) nextVowel++;
			else nextConsonant++;

			dfs(cnt + 1, i + 1, nextVowel, nextConsonant);
		}
	}

}