import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		
		int answer = 0;
		
		while(sugar >= 0) {
			if(sugar % 5 == 0) {
				answer += sugar / 5;
				sugar = 0;
				break;
			}
			
			sugar = sugar - 3;
			answer++;
			
		}
		
		if(sugar != 0) System.out.println(-1);
		else System.out.println(answer);

	}

}
