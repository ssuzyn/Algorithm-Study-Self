import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 다리 건너는 트럭 
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대 하중
        
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	truck.offer(Integer.parseInt(st.nextToken()));
        }
        
        
        for(int i = 0; i < w; i++) {
        	bridge.offer(0);
        }
        
        int bridgeWeight = 0;
        int time = 0;
        
        while(!bridge.isEmpty()) {
        	time++;
        	bridgeWeight -= bridge.poll();
        	
        	if(!truck.isEmpty()) {
        		if(truck.peek() + bridgeWeight <= L) {
        			bridgeWeight += truck.peek();
        			bridge.add(truck.poll());
        		}
        		else {
        			bridge.offer(0);
        		}
        		
        	}
        }
        
        System.out.println(time);
       
	}
}
