import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static HashMap<Long, Integer> map = new HashMap<>();
	static void add(Long num) {
		if(!map.containsKey(num))
			map.put(num, 1);
		else {
			map.remove(num);
			add(2 * num);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			if(num != 0) {
				add(num);
			}
		}
		
		System.out.println(Collections.max(map.keySet()));
		
	}

}
