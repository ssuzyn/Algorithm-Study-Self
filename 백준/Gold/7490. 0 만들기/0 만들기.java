import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static String[] op = {"+", "-", " "};
	static List<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			answer = new ArrayList<>();
			makeZero(1, "1");

			Collections.sort(answer);
			for(String s : answer){
				sb.append(s).append("\n");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static void makeZero(int cur, String str){
		if(cur == N){
			String express = str.replaceAll(" ", "");
			if(isZero(express)){
				answer.add(str);
			}
			return;
		}

		for(int i = 0; i < 3; i++){
			makeZero(cur + 1, str + op[i] + Integer.toString(cur + 1));
		}
	}

	private static boolean isZero(String express){
		StringTokenizer st = new StringTokenizer(express, "-|+", true);
		int sum = Integer.parseInt(st.nextToken());

		while(st.hasMoreTokens()){
			String s = st.nextToken();
			if(s.equals("+")) sum += Integer.parseInt(st.nextToken());
			else sum -= Integer.parseInt(st.nextToken());
		}

		return sum == 0;
	}

}
