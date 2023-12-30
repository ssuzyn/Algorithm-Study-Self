import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int useTime = sc.nextInt();
		int endTime = sc.nextInt();
		int size = sc.nextInt();
		String input = sc.next();
		
		int recordSize = endTime + size + 1;
		int[] record = new int[recordSize];
		Arrays.fill(record, 0);
		for(int i = 0; i < size; i++) {
			record[i] = Character.getNumericValue(input.charAt(i));
		}
		
		
		int one = 0;
		int zero = 0;
		int zeroIndex = 0;
		boolean using = false;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < recordSize; i++) {
			
			if(!using) {
				if(record[i] == 1) {
					one ++;
					
					if(one == useTime) {
						using = true;
						one = 0;
					}
				}
				else {
					one = 0;
				}
				
			}
			
			if(using) {
				if(record[i] == 0) {
					zero ++;
					zeroIndex = i;
					
					if(zero == endTime) {
						sb.append(i + 1).append("\n");
						zero = 0;
						one = 0;
						using = false;
					}
				}
				else {
					zero = 0;
				}
			}
			
		}
		
		
		if(sb.length() == 0)
			sb.append("NIKAD").append("\n");
		
		System.out.println(sb.toString());

	}

}
