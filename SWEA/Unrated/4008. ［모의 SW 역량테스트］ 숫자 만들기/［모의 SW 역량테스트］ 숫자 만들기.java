import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N, min, max;
	static int[] op = new int[4]; // 입력받는 연산자의 갯수 정보
	static int[] selected; // 조합된 연산자
	static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			N = Integer.parseInt(br.readLine()); // 숫자 갯수
			selected = new int[N-1];
			numbers = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			
			bw.write("#" + t + " " + (max - min) + "\n");
		}
		bw.close();
	}
	
	private static void permutation(int idx) {
		if(idx == N-1) {
			int result = numbers[0]; // 첫번째 숫자 값 넣어주기
			
			for(int i = 0; i < N-1; i++) {
				switch(selected[i]) {
				case 0: // + 연산자
					result += numbers[i+1];
					break;
				case 1: // - 연산자
					result -= numbers[i+1];
					break;
				case 2: // X 연산자
					result *= numbers[i+1];
					break;
				case 3: // / 연산자
					result /= numbers[i+1];
					break;
				}
			}
			
			// 최소값, 최대값 업데이트
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			if(op[i] < 1) continue;
			
			selected[idx] = i;
			op[i]--;
			permutation(idx + 1);
			op[i]++;
		}
	}
}
