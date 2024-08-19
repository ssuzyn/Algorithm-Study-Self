import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer;
	static int[][] table;
	static boolean[] numbers;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			numbers = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			
			bw.write("#" + t + " " + answer + "\n");
		}
		bw.close();
	}
	
	private static int cal() {
		int foodA = 0;
		int foodB = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if(numbers[i] && numbers[j]) // A음식 조합 완료
					foodA += table[i][j];
				
				else if(!numbers[i] && !numbers[j]) { // A음식으로 조합되지 않은 나머지 식재료
					foodB += table[i][j];
				}
			}
		}
		
		return Math.abs(foodA - foodB);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == N/2) {
			answer = Math.min(answer, cal());
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[i] = true;
			combination(cnt + 1, i + 1);
			numbers[i] = false;
		}
	}

}
