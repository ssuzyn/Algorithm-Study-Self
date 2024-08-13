import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
 	static int []numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M]; // 순열 저장 배열
		isSelected = new boolean[N+1]; // 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열
		permutation(0);
	}
	
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt + 1);
			
			isSelected[i] = false; // 다음 재귀호출에 영향을 주지 않기 위해 백트래킹
		}
	}
}
