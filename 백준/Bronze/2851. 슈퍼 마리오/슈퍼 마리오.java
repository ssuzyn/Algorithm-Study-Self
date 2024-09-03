import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int ans = 0;
		
		for(int i = 0; i < 10; i++) {
			int mushroom = Integer.parseInt(br.readLine());
			sum += mushroom;
			
			if(Math.abs(100 - sum) <= Math.abs(100 - ans))
				ans = sum;
			
		}
		
		System.out.println(ans);
		
	}

}
