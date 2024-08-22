import java.util.Scanner;

public class Solution {

	static int N, ans;
	static int[] col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			col = new int[N + 1]; // 1행 부터 사용
			ans = 0;
			
			setQueens(1);
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static void setQueens(int rowNo) {
		
		if(!isAvailable(rowNo - 1)) return;
		
		if(rowNo > N) { // 무조건 답
			ans++;
			return;
		}
		
		for(int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueens(rowNo + 1);
		}
	}
	
	static boolean isAvailable(int rowNo) { // 새로운 퀸을 놓기 전에 현재까지의 선택이 올바른지 검증
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) { // 같은 열에 있거나, 같은 대각선에 있는 경우
				return false;
			}
		}
		
		return true;
	}
}
