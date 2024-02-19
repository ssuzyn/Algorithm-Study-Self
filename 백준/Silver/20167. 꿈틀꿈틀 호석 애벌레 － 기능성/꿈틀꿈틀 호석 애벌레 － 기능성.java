import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> feed = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		int sum = 0;
		int energy = 0;
		int start = 0, end = 0;
		
		for(int i = 0; i < N; i++) {
			feed.add(Integer.parseInt(st.nextToken()));
		}
		
		while(end < N) {
			sum += feed.get(end);
			
			if(sum >= K) {
				result.add(sum);
				sum = 0;
			}
			else {
				end++;
				continue;
			}
			
			
			if(result.size() == 2) {
				int maxEnergy = Math.max(result.get(0), result.get(1));
				energy += (maxEnergy - K);
				result.clear();
				
				end++;
				start = end;
				continue;
			}
			else if(!result.isEmpty() && end + 1 == N) {
				energy += (result.get(0) - K);
			}
			
			
			start++;
			end = start;
		}
		
		System.out.println(energy);

	}

}
