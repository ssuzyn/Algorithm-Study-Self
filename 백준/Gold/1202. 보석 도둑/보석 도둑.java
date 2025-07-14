import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] bag;

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
		N = Integer.parseInt(st.nextToken()); // 보석 개수
		K = Integer.parseInt(st.nextToken()); // 가방 개수
		bag = new int[K];
		Jewel[] jewelList = new Jewel[N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			jewelList[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < K; i++){
			bag[i] = Integer.parseInt(br.readLine());
		}

		// 보석을 무게 순으로 정렬
		Arrays.sort(jewelList, (j1, j2) -> j1.weight - j2.weight);

		// 가방을 무게 순으로 정렬
		Arrays.sort(bag);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long answer = 0;
		int jewelIdx = 0;

		for(int i = 0; i < K; i++){
			while(jewelIdx < N && jewelList[jewelIdx].weight <= bag[i]){
				pq.add(jewelList[jewelIdx].price);
				jewelIdx++;
			}

			if(!pq.isEmpty()) answer += pq.poll();
		}

		System.out.println(answer);
	}
}