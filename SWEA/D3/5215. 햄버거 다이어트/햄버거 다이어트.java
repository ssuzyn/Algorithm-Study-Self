import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L;
	static int[][] food;
	static int maxScore;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			food = new int[N][2];
			maxScore = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken()); // 점수
				food[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			hamburger(0, 0, 0);
			System.out.println("#" + t + " " + maxScore);
		}
	}
	
	public static void hamburger(int idx, int score, int calorie) {
		
		if(calorie > L) {
			return;
		}
		
		if(idx == N) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		hamburger(idx + 1, score + food[idx][0], calorie + food[idx][1]);
		hamburger(idx + 1, score, calorie);
	}
}
