import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1};
	static List<ArrayList<Integer>> fuel;	
	static int []visited;
	static int result = Integer.MAX_VALUE;
	static int N, M;
	
	public static boolean isValid(int y) {
		return y < M && y > -1;
	}
	
	public static void move(int depth, int y, int dir) {

		if(depth == N) {
			int sum = fuel.get(0).get(visited[0]);
			for(int i = 1; i < N; i++) {
				sum += fuel.get(i).get(visited[i]);
			}
			
			result = Math.min(sum, result);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int newY = y + dy[i];
			if(isValid(newY) && dir != i) {
				visited[depth] = newY;
				move(depth+1, newY, i);
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		fuel = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			fuel.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				fuel.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < M; i++) {
			visited = new int[N];
			visited[0] = i; // 0행 i열 방문했다.
			move(1, i, -1);
		}
		
		System.out.println(result);
		
		
	}

}
