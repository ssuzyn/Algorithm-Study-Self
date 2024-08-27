import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
    static int K;
    static int[] dx = {-1, 1, 2};
    static int[] visited = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈이의 위치
		K = sc.nextInt(); // 동생의 위치
		
		if(N == K) {
			System.out.println(0);
		}
		else {
			bfs(N);
		}
	}
	
	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = 1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				
				if(i == 2) next = tmp * dx[i];
				else next = tmp + dx[i];
				
				if(next == K) {
					System.out.println(visited[tmp]);
					return;
				}
				
				if(next >= 0 && next < visited.length && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[tmp] + 1;
				}
			}
		}
		
	}
}
