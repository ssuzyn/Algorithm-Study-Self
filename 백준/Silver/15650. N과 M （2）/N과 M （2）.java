import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		numbers = new int[M];
		permutation(0, 1);
		
	}
	
	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			permutation(cnt+1, i+1);
		}
	}
	
}
