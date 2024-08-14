import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] input = new int[9];
	static int[] dwarf = new int[7];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		findDwarf(0, 0, 0);
		
	}
	
	// cnt: 기존까지 뽑은 수의 개수
	// start: 탐색 시작 인덱스
	// sum: 선택된 난쟁이의 모자 숫자 합
	private static void findDwarf(int cnt, int start, int sum) {
		
		if(cnt == dwarf.length) {
			if(sum == 100) {
				for(int d : dwarf) {
					System.out.println(d);
				}
			}
			return;
		}
		
		
		for(int i = start; i < 9; i++) {
			dwarf[cnt] = input[i];
			findDwarf(cnt + 1, i + 1, sum + input[i]);
		}
	}
}
