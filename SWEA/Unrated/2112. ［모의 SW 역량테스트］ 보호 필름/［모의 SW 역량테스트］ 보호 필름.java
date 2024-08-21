import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K;
	static int[][] film;
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
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			drug(0, 0);
			System.out.println("#" + t + " " + drugCnt);
			
		}
	}
	
	// idx: 약물투여 대상 행의 위치, cnt: 약물 투여 횟수
	private static void drug(int idx, int cnt) {
		
		if(test()) { // 검사에 통과한 경우, 최소 투여 횟수로 설정
			drugCnt = Math.min(cnt, drugCnt);
			return;
		}
		
		if(cnt > drugCnt) return; // 최소 투여 횟수보다 많은 경우 return
		
		if(idx == D) return; // 모든 행을 탐색한 경우 return
			
		
		int[] memory = new int[W];
		
		// 약물 투여하지 않고 검사하기
		for(int i = 0; i < W; i++) {
			memory[i] = film[idx][i];
		}
		drug(idx + 1, cnt);
		
		// idx행 약품 A 투여하고 검사하기
		for(int i = 0; i < W; i++) {
			film[idx][i] = 0;
		}
		drug(idx + 1, cnt + 1);
		
		// idx행 약품 B 투여하고 검사하기
		for(int i = 0; i < W; i++) {
			film[idx][i] = 1;
		}
		drug(idx + 1, cnt + 1);
		
		// idx행 원상복구
		film[idx] = Arrays.copyOf(memory, memory.length);
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

}
