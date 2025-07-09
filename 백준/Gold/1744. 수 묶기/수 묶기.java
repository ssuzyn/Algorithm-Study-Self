import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int zero = 0;
		PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue<>();

		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			if(num == 1) sum++;
			else if(num > 1) positive.add(num);
			else if(num < 0) negative.add(num);
			else zero++;
		}

		while(positive.size() > 1){
			sum += positive.poll() * positive.poll();
		}

		while(negative.size() > 1){
			sum += negative.poll() * negative.poll();
		}

		if(!positive.isEmpty()) sum += positive.poll();
		if(!negative.isEmpty() && zero == 0){
			sum += negative.poll();
		}

		System.out.println(sum);

	}
}