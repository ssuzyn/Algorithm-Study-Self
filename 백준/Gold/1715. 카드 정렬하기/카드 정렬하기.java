import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while(N-- > 0){
			pq.add(Integer.parseInt(br.readLine()));
		}

		int answer = 0;
		while(pq.size() > 1){
			int tmp = pq.poll() + pq.poll();
			answer += tmp;
			pq.add(tmp);
		}

		System.out.println(answer);

	}
}