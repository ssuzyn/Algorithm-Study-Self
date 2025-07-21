import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N, M;
	static int[] map = new int[101];
	static int[] ladder = new int[101];
	static int[] snake = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리의 수
		M = Integer.parseInt(st.nextToken()); // 뱀의 수

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		bfs();
	}

	private static void bfs(){
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[101];

		q.add(new int[]{1, 0});
		visited[1] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int idx = cur[0];
			int cnt = cur[1];

			if(idx == 100){
				System.out.println(cnt);
				return;
			}

			for(int i = 1; i <= 6; i++){
				int next = idx + i;
				if(next > 100 || visited[next]) continue;

				visited[next] = true;

				if(ladder[next] > 0) { // 사다리가 있는 경우
					visited[ladder[next]] = true;
					q.add(new int[]{ladder[next], cnt + 1});
				}
				else if(snake[next] > 0) { // 뱀이 있는 경우
					visited[snake[next]] = true;
					q.add(new int[]{snake[next], cnt + 1});
				}
				else q.add(new int[]{next, cnt + 1});

			}
		}
	}
	
}