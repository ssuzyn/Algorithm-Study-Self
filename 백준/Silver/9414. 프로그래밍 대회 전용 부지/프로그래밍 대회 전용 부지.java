import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());

		int maxPrice = (int) (5 * Math.pow(10, 6));
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(count > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				
				Collections.sort(arr, Collections.reverseOrder());
				
				int price = 0;
				for(int i = 1; i <= arr.size(); i++) {
					price += 2 * Math.pow(arr.get(i-1), i);
				}
				
				if(price > maxPrice) sb.append("Too expensive");
				else sb.append(Integer.toString(price));
				sb.append("\n");
				
				
				arr.clear();
				count--;
			}
			
			else {
				arr.add(n);
			}
		}
		
		System.out.println(sb);
		
	}
}
