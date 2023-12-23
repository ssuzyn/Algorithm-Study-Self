import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int type = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int doughPrice= Integer.parseInt(st.nextToken());
		int toppingPrice = Integer.parseInt(st.nextToken());
		int doughCalorie = Integer.parseInt(br.readLine());
		
		int totalPrice = doughPrice;
		int totalCalorie = doughCalorie;
		
		List<Integer> calorie = new ArrayList<>();
		for(int i = 0; i < type; i++) {
			calorie.add(Integer.parseInt(br.readLine()));
		}
		
		int basicCalPerPrice = doughCalorie / doughPrice;
		int maxCalPerPrice = basicCalPerPrice;
		
		Collections.sort(calorie, Collections.reverseOrder());
		
		for(int i = 0; i < type; i++) {
			totalPrice += toppingPrice;
			totalCalorie += calorie.get(i);
			
			maxCalPerPrice = Math.max(maxCalPerPrice, totalCalorie/totalPrice);
		}
		
		System.out.println(maxCalPerPrice);
		
	}

}
