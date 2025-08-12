import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] city;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 수
		city = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][(1 << N)];
		for(int i = 0; i < N; i++){
			Arrays.fill(dp[i], -1);
		}

		// 0번 도시에서 시작
		System.out.println(tsp(0, 1));
	}

	private static int tsp(int cur, int visited){
		// N개의 도시를 모두 방문한 경우
		if(visited == (1 << N) - 1){
			if(city[cur][0] != 0){ // 출발 도시로 돌아올 수 있는 경우에만
				return city[cur][0];
			}
			return Integer.MAX_VALUE / 2;
		}

		// 이미 계산한 경우
		if(dp[cur][visited] != -1) {
			return dp[cur][visited];
		}

		dp[cur][visited] = Integer.MAX_VALUE / 2;

		for(int next = 0; next < N; next++){
			if((visited & (1 << next)) != 0 || city[cur][next] == 0) continue;
			dp[cur][visited] = Math.min(dp[cur][visited], city[cur][next] + tsp(next, visited | (1 << next)));
		}

		return dp[cur][visited];
	}

}
