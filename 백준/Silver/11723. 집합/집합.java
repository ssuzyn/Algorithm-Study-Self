import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] set = new int[21];
		while(M-- > 0) {
			String[] input = br.readLine().split(" ");
			String op = input[0]; // 연산자

			if(input.length > 1) {
				int num = Integer.parseInt(input[1]); // 피연산자
				
				switch(op) {
				case "add":
					set[num] = 1;
					break;
					
				case "check":
					if((set[num] & 1) != 0) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}

					sb.append("\n");
					break;
					
				case "remove":
					set[num] = 0;
					break;
				
				case "toggle":
					if((set[num] & 1) != 0) {
						set[num] = 0;
					}
					else {
						set[num] = 1;
					}
					break;
				}
				
			}
			else {
				switch(op) {
				
				case "all":
					for(int i = 1; i <= 20; i++) {
						set[i] = 1;
					}
					break;
					
				case "empty":
					for(int i = 1; i <= 20; i++) {
						set[i] = 0;
					}
					break;
				}
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
