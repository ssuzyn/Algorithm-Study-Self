import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int N;
	static int[][] farm;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = input.charAt(j) - '0';
				}
			}
			
			System.out.println("#" + t + " " + solve());
			
		}
		
		
		
	}
	
	private static int solve() {
		
		int start = N/2;
		int end = N/2;
		int sum = 0;
		
		for(int x = 0; x < N; x++) {
			for(int i = start; i <= end; i++) {
				sum += farm[x][i];
			}
			
			if(x < N/2) {
				start--;
				end++;
			}
			else {
				start++;
				end--;
			}
		}
		
		return sum;
	}

}
