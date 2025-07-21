import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N, M;
	static int[] map = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리의 수
		M = Integer.parseInt(st.nextToken()); // 뱀의 수

		for(int i = 0; i < N + M; i++){
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
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
			int idx = cur[0]; // 현재 위치
			int cnt = cur[1]; // 주사위 던진 횟수

			if(idx == 100){
				System.out.println(cnt);
				return;
			}

			for(int i = 1; i <= 6; i++){
				int next = idx + i;
				if(next > 100 || visited[next]) continue;

				visited[next] = true;
				
				if(map[next] != 0){ // 사다리나 뱀이 있는 경우
					next = map[next];
					visited[next] = true;
				}

				q.add(new int[]{next, cnt + 1});
			}
		}
	}

}