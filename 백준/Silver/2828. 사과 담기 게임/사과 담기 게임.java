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
		
		List<Integer> fall = new ArrayList<>();
		for(int i = 0; i < apple; i++) {
			fall.add(Integer.parseInt(br.readLine()));
		}
		
		int front = 1, back = bucketSize;
		int count = 0;
		for(int i = 0; i < apple; i++) {
			int position = fall.get(i);
			
			if(position > back) {
				while(back < position && back < screenSize){
					count++;
					front++;
					back++;
				}
			}
			else if(position < front) {
				while(front > position && front > 1) {
					count++;
					front--;
					back--;
				}
			}
		} 
		System.out.println(count);

	}

}
