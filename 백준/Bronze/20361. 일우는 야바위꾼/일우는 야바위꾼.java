import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();

		for(int i = 0; i < K; i++) {
			int idx1 = sc.nextInt();
			int idx2 = sc.nextInt();
			
			if(idx1 == X) X = idx2;
			else if(idx2 == X) X = idx1;
		}
		System.out.println(X);
	}

}
