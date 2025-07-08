import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static class Meeting{
		int start;
		int end;

		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회의의 수
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>((m1, m2) -> {
			if(m1.end == m2.end) {
				return m1.start - m2.start;
			}
			return m1.end - m2.end;
		});

		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int answer = 1;
		Meeting tmp = pq.poll();

		while(!pq.isEmpty()){
			Meeting next = pq.poll();

			if(tmp.end <= next.start){
				answer++;
				tmp = next;
			}
		}

		System.out.println(answer);
	}
}