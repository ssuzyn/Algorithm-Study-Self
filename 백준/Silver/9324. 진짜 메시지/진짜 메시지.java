import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
	
		for(int i = 0; i < n; i++) {
			
			int[] value = new int[26];
			String msg = scan.nextLine();
			
			boolean isFake = false;
			
			for(int j = 0; j < msg.length(); j++) {
				int index = msg.charAt(j) - 'A';
				value[index]++;
				
				if(value[index] == 3) {
					if(j == msg.length()-1 || msg.charAt(j+1) != msg.charAt(j)) {
						isFake = true;
					}
					
					value[index] = 0;
					j++;
				}
				
			}
			
			if(isFake)
				System.out.println("FAKE");
			else
				System.out.println("OK");
			
		}
	
		
	}
}
