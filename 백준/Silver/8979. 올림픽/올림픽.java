import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static class Nation implements Comparable<Nation> {
		int num, gold, silver, bronze;

		Nation(int num, int gold, int silver, int bronze){
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Nation other) {
			if(this.gold != other.gold) return other.gold - this.gold;
			else if(this.silver != other.silver) return other.silver - this.silver;
			return other.bronze - this.bronze;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 국가 수
		int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

		PriorityQueue<Nation> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			pq.add(new Nation(num, gold, silver, bronze));
		}

		int rank = 1;
		int count = 0;
		Nation prev = pq.poll();

		if(prev.num == K){
			System.out.println(rank);
			return;
		}

		while(!pq.isEmpty()){
			Nation cur = pq.poll();
			count++;

			// 금, 은, 동 갯수가 모두 다르면
			if(!(prev.gold == cur.gold && prev.silver == cur.silver && prev.bronze == cur.bronze)) rank = count + 1;
			if(cur.num == K) break;
			prev = cur;
		}

		System.out.println(rank);

	}
}