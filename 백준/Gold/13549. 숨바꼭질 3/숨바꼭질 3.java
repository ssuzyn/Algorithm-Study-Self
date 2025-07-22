import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		if(N == K) {
			System.out.println(0);
			return;
		}

		bfs();
	}

	private static void bfs(){
		Deque<int[]> q = new LinkedList<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);

		q.add(new int[]{N, 0});
		visited[N] = 0;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int idx = cur[0]; // 현재 위치
			int time = cur[1]; // 현재 시간

			if(idx == K) {
				System.out.println(time);
				return;
			}

			int[] dir = {idx - 1, idx + 1, idx * 2};
			for(int i = 0; i < dir.length; i++){
				int next = dir[i];
				int nextTime = (i == 2) ? time : time + 1;

				if(0 <= next && next < 100001 && visited[next] > nextTime){
					visited[next] = nextTime;

					if(i == 2) q.addFirst(new int[]{next, nextTime});
					else q.addLast(new int[]{next, nextTime});
				}
			}
		}
	}
}