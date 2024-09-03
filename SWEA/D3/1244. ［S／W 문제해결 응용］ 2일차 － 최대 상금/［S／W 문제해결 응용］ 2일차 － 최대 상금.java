import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int swap, ans;
	static char[] money;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			money = st.nextToken().toCharArray(); // 최대 자릿수
			swap = Integer.parseInt(st.nextToken()); // 교환 횟수
			ans = Integer.MIN_VALUE;
			
			if(money.length < swap) // swap 횟수가 자릿수보다 클 때 
				swap = money.length; // 자릿수만큼 옮겨도 전부 옮길 수 있다.
			
			dfs(0, 0);
			System.out.println("#" + t + " " + ans);
		}
		

	}
	
	static void dfs(int cnt, int start) {
		if(cnt == swap) {
			int sum = Integer.parseInt(String.valueOf(money));
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = start; i < money.length - 1; i++) {
			for(int j = i + 1; j < money.length; j++) {
				swapNumber(i, j);
				dfs(cnt + 1, i); // 동일한 위치의 교환 중복 OK
				swapNumber(i, j);
			}
		}
	}
	
	static void swapNumber(int i, int j) {
		char tmp = money[i];
		money[i] = money[j];
		money[j] = tmp;
	}

}
