import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<>();

		for(int i = 0; i < N; i++){
			words.add(br.readLine());
		}

		int idx1 = -1; int idx2 = -1;
		int max = 0;
		for(int i = 0; i < N - 1; i++){
			for(int j = i + 1; j < N; j++){
				String word1 = words.get(i);
				String word2 = words.get(j);

				int len = getCommonPrefixLength(word1, word2);
				if(max < len){
					max = len;
					idx1 = i;
					idx2 = j;
				}
			}
		}

		System.out.println(words.get(idx1));
		System.out.println(words.get(idx2));
	}

	private static int getCommonPrefixLength(String s1, String s2) {
		int len = 0;
		int minLen = Math.min(s1.length(), s2.length());

		for(int i = 0; i < minLen; i++) {
			if(s1.charAt(i) == s2.charAt(i)) len++;
			else break;
		}
		return len;
	}

}