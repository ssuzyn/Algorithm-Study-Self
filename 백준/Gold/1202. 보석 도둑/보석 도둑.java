import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Jewel{
		int weight;
		int price;

		Jewel(int weight, int price){
			this.weight = weight;
			this.price = price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수

		PriorityQueue<Integer> bag = new PriorityQueue<>();
		PriorityQueue<Jewel> jewels = new PriorityQueue<>((j1, j2) -> j1.weight - j2.weight);
		PriorityQueue<Integer> price = new PriorityQueue<>(Collections.reverseOrder());

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			jewels.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for(int i = 0; i < K; i++){
			bag.offer(Integer.parseInt(br.readLine()));
		}

		long answer = 0;

		while(!bag.isEmpty()){
			int curBag = bag.poll();

			while(!jewels.isEmpty()){
				if(jewels.peek().weight > curBag) break;
				price.add(jewels.poll().price);
			}

			if(!price.isEmpty()) answer += price.poll();
		}

		System.out.println(answer);
	}
}