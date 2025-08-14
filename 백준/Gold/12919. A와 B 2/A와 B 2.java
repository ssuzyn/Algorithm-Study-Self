import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		System.out.println(dfs(S, T) ? 1 : 0);
	}

	private static boolean dfs(String S, String T){
		if(T.length() < S.length()) return false;

		if(S.length() == T.length()) return S.equals(T);

		// T에서 S로 변환 가능한지 확인
		// T가 'A'로 끝나면 A 제거
		if(T.charAt(T.length() - 1) == 'A') {
			if(dfs(S, T.substring(0, T.length() - 1))) return true;
		}

		// T가 'B'로 시작하면 B 제거 후 뒤집기
		if(T.charAt(0) == 'B'){
			String reversed = new StringBuilder(T.substring(1)).reverse().toString();
			if(dfs(S, reversed)) return true;
		}

		return false;
	}

}