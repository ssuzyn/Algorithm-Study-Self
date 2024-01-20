import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int size = 10001;
	static int result;
	static boolean[] visited;
	static List<ArrayList<Bridge>> city = new ArrayList<>();
	
	static class Bridge{
		int to;
		int value;
		
		Bridge(int to, int value){
			this.to = to;
			this.value = value;
		}
		
		int getTo() {
			return to;
		}
		
		int getValue() {
			return value;
		}
	}
	
	static void dfs(int from, int value) {
		visited[from] = true;
		
		for(int i = 0; i < city.get(from).size(); i++) {
			Bridge nextBridge = city.get(from).get(i);
			if(!visited[nextBridge.getTo()]) {
				dfs(nextBridge.getTo(), nextBridge.getValue() + value);
			}
			if(visited[nextBridge.getTo()]) {
				result = Math.max(value, result);
			}
		}
		
		visited[from] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		visited = new boolean[size];
		for(int i = 0; i < size; i++) {
			city.add(new ArrayList<>());
		}
		
		while(true) {
			int a, b, c;
			
			try {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
			}catch(Exception e) {
				break;
			}
			
			city.get(a).add(new Bridge(b, c));
			city.get(b).add(new Bridge(a, c));
		}
		
		for(int i = 0; i < size; i++) {
			dfs(i, 0);
		}
		
		System.out.println(result);
		
		
	}

}
