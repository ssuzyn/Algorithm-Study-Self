import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		Stack<Integer> block = new Stack<>();
		int answer = 0;
		int limit = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(tmp >= limit) {
				while(!block.isEmpty()) {
					answer += (limit - block.pop());
				}
				limit = tmp;

			}
			else {
				block.push(tmp);
			}
						
		}
		
		
		if(!block.isEmpty() && block.size() > 1) {
			int end = block.pop();
			
			while(!block.isEmpty()) {
				int tmp = block.pop();
				if(tmp < end) {
					answer += end - tmp;
				}
				else {
					end = tmp;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
