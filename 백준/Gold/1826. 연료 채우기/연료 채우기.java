import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 주유소 개수
		PriorityQueue<int[]> stations = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 주유소 위치
			int b = Integer.parseInt(st.nextToken()); // 트럭 연료량

			stations.add(new int[]{a, b});
		}

		st = new StringTokenizer(br.readLine());
		int town = Integer.parseInt(st.nextToken()); // 마을 위치
		int curFuel = Integer.parseInt(st.nextToken()); // 트럭 연료량

		int answer = 0;
		PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

		while(curFuel < town){
			// 현재 연료로 갈 수 있는 주유소 추가
			while(!stations.isEmpty() && stations.peek()[0] <= curFuel){
				fuels.add(stations.poll()[1]);
			}

			if(fuels.isEmpty()){
				System.out.println(-1);
				return;
			}

			answer++;
			curFuel += fuels.poll();
		}

		System.out.println(answer);
	}
}
