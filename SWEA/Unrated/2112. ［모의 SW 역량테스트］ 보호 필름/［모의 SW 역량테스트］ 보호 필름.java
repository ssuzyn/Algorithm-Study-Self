import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K;
	static int[][] film;
	static int[][] map;
	static boolean[] isSelected;
	static int drugCnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 보호필름의 두께
			W = Integer.parseInt(st.nextToken()); // 보호필름의 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준

			drugCnt = Integer.MAX_VALUE;
			film = new int[D][W];
			map = new int[D][W];
			isSelected = new boolean[D];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = film[i][j];
				}
			}
			

			if(test()) {
				System.out.println("#" + t + " " + 0);
			}
			else {
				subSet(0);
				System.out.println("#" + t + " " + drugCnt);
			}
			
		}
	}
	
	// 부분 집합으로 투여할 행 선택하기
	private static void subSet(int idx) {
		if(idx == D) {
			drug(isSelected, 0, 0);
			reset();
			return;
		}
		

		subSet(idx + 1);
		
		isSelected[idx] = true;
		subSet(idx + 1);
		isSelected[idx] = false;
	}
	
	// idx: 약물투여 대상 행의 위치, cnt: 약물 투여 횟수
	private static void drug(boolean[] isSelected, int idx, int cnt) {
		
		if(cnt >= drugCnt) return;
		
		if(idx == D) {
			if(test()) {
				drugCnt = Math.min(cnt, drugCnt);
			}
			return;
		}
		
		if(isSelected[idx]) {

			Arrays.fill(film[idx], 1);
			drug(isSelected, idx + 1, cnt + 1);
				
			Arrays.fill(film[idx], 0);
			drug(isSelected, idx + 1, cnt + 1);
		}
		else {
			drug(isSelected, idx + 1, cnt);
		}
		
 	}
	
	
	private static boolean test() {
		for(int i = 0; i < W; i++) {
			int count = 1;
			boolean pass = false;
			for(int j = 1; j < D; j++) {
				if(film[j - 1][i] == film[j][i]) {
					count++;
				}
				else {
					count = 1;
				}
				
				if(count >= K) {
					pass = true;
					break;
				}
			}
			
			if(!pass) return false;
		}
		
		return true;
		
	}
	
	// 보호필름 초기화 하기
	private static void reset() {
		for(int i = 0; i < D; i++) {
			for(int j = 0; j < W; j++) {
				film[i][j] = map[i][j];
			}
		}
	}
	
}
