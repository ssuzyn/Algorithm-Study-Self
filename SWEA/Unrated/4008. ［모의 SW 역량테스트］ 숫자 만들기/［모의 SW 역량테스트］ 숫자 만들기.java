import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] input = new int[4]; // 입력받는 연산자의 갯수 정보
	static int[] op; // 조합된 연산자
	static int[] numbers;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 숫자 갯수
			op = new int[N-1];
			numbers = new int[N];
			answer = new ArrayList<>();
			
			int opSize = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			Collections.sort(answer); // 수식으로 얻은 결과값 오름차순 정렬
			
			
			
			bw.write("#" + t + " " + Math.abs(answer.get(0) - answer.get(answer.size()-1)) + "\n");
		}
		bw.close();
	}
	
	private static void permutation(int idx) {
		if(idx == N-1) {
			cal();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(input[i] < 1) continue;
			
			op[idx] = i;
			input[i]--;
			permutation(idx + 1);
			input[i]++;
		}
	}
	
	private static void cal() {
		int result = numbers[0];
		
		for(int i = 0; i < N-1; i++) {
			switch(op[i]) {
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
		
		answer.add(result);
	}
}
