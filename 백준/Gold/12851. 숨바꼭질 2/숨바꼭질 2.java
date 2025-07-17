import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, minTime, count;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈
		K = Integer.parseInt(st.nextToken()); // 동생

		minTime = Integer.MAX_VALUE;
		count = 0;
		Arrays.fill(visited, -1);

		if(N == K){
			System.out.println(0);
			System.out.println(1);
		}
		else{
			bfs();
			System.out.println(minTime);
			System.out.println(count);
		}
	}

	private static void bfs(){
		Queue<int[]> q = new LinkedList<>();
		visited[N] = 0; // 시작점 시간 기록
		q.add(new int[]{N, 0});

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int pos = cur[0];
			int time = cur[1];

			if(pos == K){
				if(minTime > time){
					minTime = time;
					count = 1;
				}
				else if(minTime == time){
					count++;
				}
				continue;
			}

			if(time >= minTime) continue; // 가지치기

			// 세 방향 이동
			int[] nextPos = {pos - 1, pos + 1, pos * 2};
			for(int next : nextPos){
				if(next >= 0 && next <= 100000) {
					// 아직 방문 안했거나, 같은 시간에 도달하는 경우만 허용
					if(visited[next] == -1 || visited[next] == time + 1){
						if(visited[next] == -1){
							visited[next] = time + 1;
						}
						q.add(new int[]{next, time + 1});
					}
				}
			}
		}
	}
}