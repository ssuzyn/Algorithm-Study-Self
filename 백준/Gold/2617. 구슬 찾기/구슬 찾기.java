import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static List<Integer>[] heavyList;
	static List<Integer>[] lightList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 구슬의 개수
		M = Integer.parseInt(st.nextToken()); // 저울에 올린 쌍의 개수

		heavyList = new ArrayList[N + 1];
		lightList = new ArrayList[N + 1];

		for(int i = 1; i <= N; i++){
			heavyList[i] = new ArrayList<>();
			lightList[i] = new ArrayList<>();
		}


		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a > b
			heavyList[b].add(a);
			lightList[a].add(b);
		}

		int answer = 0;
		int mid = N / 2;
		for(int i = 1; i <= N; i++){
			int heavyCount = dfs(i, heavyList, new boolean[N+1]);
			int lightCount = dfs(i, lightList, new boolean[N+1]);

			if(heavyCount > mid || lightCount > mid){
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static int dfs(int tmp, List<Integer>[] list, boolean[] visited){
		int count = 0;
		visited[tmp] = true;

		for(int i : list[tmp]){
			if(!visited[i]) count += 1 + dfs(i, list, visited);
		}
		return count;
	}
	
}