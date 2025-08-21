import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] alphabet = new boolean[26];
		StringBuilder sb = new StringBuilder();

		while(N-- > 0) {
			String[] words = br.readLine().split(" ");
			boolean found = false;

			// 1단계: 각 단어의 첫 글자에서 단축키 찾기
			for(int i = 0; i < words.length; i++) {
				char word = words[i].charAt(0);
				int idx = Character.toLowerCase(word) - 'a';
				if(!alphabet[idx]) {
					alphabet[idx] = true;
					found = true;
					words[i] = words[i].replaceFirst(String.valueOf(word), "[" + word + "]");
					break;
				}
			}

			// 2단계: 첫 글자로 못 찾았으면 모든 글자 순서대로 확인
			if(!found) {
				for(int i = 0; i < words.length; i++) {
					for(int j = 0; j < words[i].length(); j++){
						char word = words[i].charAt(j);
						int idx = Character.toLowerCase(word) - 'a';
						if(!alphabet[idx]){
							alphabet[idx] = true;
							found = true;
							words[i] = words[i].replaceFirst(String.valueOf(word), "[" + word + "]");
							break;
						}

						if(found) break;
					}
				}
			}

			for(String word : words){
				sb.append(word).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

}