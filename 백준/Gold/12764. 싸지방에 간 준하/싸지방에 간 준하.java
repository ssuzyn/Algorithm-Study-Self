import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Computer{
		int idx;
		int end;

		Computer(int idx, int end){
			this.idx = idx;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] people = new int[N][2];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}

		// 컴퓨터 사용 시작 시간으로 정렬
		Arrays.sort(people, (p1, p2) -> p1[0] - p2[0]);

		int seatNum = 0;
		int[] seat = new int[N];
		PriorityQueue<Computer> computers = new PriorityQueue<>((c1, c2) -> c1.end - c2.end);
		PriorityQueue<Integer> availableSeat = new PriorityQueue<>();

		for(int[] p : people){
			while(!computers.isEmpty() && computers.peek().end < p[0]){
				availableSeat.add(computers.poll().idx); // 앉을 수 있는 자리 번호
			}

			int num = availableSeat.isEmpty()? seatNum++ : availableSeat.poll();
			computers.add(new Computer(num, p[1]));
			seat[num]++;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(seatNum + "\n");
		for(int i = 0; i < seatNum; i++){
			sb.append(seat[i] + " ");
		}

		System.out.println(sb);
	}

}