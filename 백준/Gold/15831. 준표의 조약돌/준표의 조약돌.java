import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		char[] stone = br.readLine().toCharArray();

		int start = 0, end = 0;
		int blackCnt = 0, whiteCnt = 0;
		int result = 0;
		
		while(end < N) {
			
			if(blackCnt > B) {
				if(stone[start] == 'W') whiteCnt--;
				else blackCnt --;
				start++;
			}
			else {
				if(stone[end] == 'W') whiteCnt++;
				else blackCnt++;
				end++;
			}
			
			if(blackCnt <= B && whiteCnt >= W) {
				result = Math.max(result, end - start);
			}
			
		}
		
		System.out.println(result);
	}

}
