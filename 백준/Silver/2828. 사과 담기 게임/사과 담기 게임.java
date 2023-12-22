import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int screenSize = Integer.parseInt(st.nextToken());
		int bucketSize = Integer.parseInt(st.nextToken());
		int apple = Integer.parseInt(br.readLine());
		
		
		int left = 0;
		int right = bucketSize - 1;
		int move = 0;
		
		for(int i = 0; i < apple; i++) {
			int position = Integer.parseInt(br.readLine()) - 1;
			
			if(position > right) {
				move += position - right;
				right = position;
				left = right - (bucketSize - 1);
			}
			else if(position < left) {
				move += left - position;
				left = position;
				right = left + (bucketSize - 1);
			}
		} 
		System.out.println(move);

	}

}
