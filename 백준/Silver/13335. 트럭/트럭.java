import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 트럭의 개수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < w; i++) {
			bridge.add(0);
		}
	
		int time = 0;
		int weight = 0;
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			
			while(!truck.isEmpty()) {
				int tmp = truck.peek();
				
				if(weight + tmp <= L) {
					truck.poll();
					bridge.add(tmp);
					weight += tmp;
					break;
					
				}
				else {
					bridge.add(0);
					break;
				}
			}
		}
		
		System.out.println(time);
	}
}