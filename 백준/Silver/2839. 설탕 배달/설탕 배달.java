import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		
		int answer = 0;
		
		while(sugar >= 0) {
			if(sugar % 5 == 0) {
				answer += sugar / 5;
				System.out.println(answer);
				return;
			}
			
			sugar = sugar - 3;
			answer++;
			
		}
		
		System.out.println(-1);

	}

}
