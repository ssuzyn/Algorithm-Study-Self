import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int[][][] dp;
	static int[][] possibleAttack = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] SCV = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			SCV[i] = Integer.parseInt(st.nextToken());
		}

		bfs(SCV);
		System.out.println(dp[0][0][0]);

	}

	private static void bfs(int[] SCV){
		Queue<int[]> q = new LinkedList<>();
		q.add(SCV);

		// 각 상태에 도달하는데 필요한 최소 공격 횟수
		dp = new int[SCV[0] + 1][SCV[1] + 1][SCV[2] + 1];
		dp[SCV[0]][SCV[1]][SCV[2]] = 0;

		while(!q.isEmpty()){
			int[] tmp = q.poll();

			if(tmp[0] == 0 && tmp[1] == 0 && tmp[2] == 0) break;

			for(int i = 0; i < 6; i++){ // 모든 경우의 공격
				int[] attack = possibleAttack[i];

				int a = Math.max(tmp[0] - attack[0], 0); // 체력이 음수가 될 수 없다.
				int b = Math.max(tmp[1] - attack[1], 0);
				int c = Math.max(tmp[2] - attack[2], 0);

				if(dp[a][b][c] == 0) { // 아직 방문하지 않은 상태라면
					q.add(new int[]{a, b, c});
					dp[a][b][c] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;

				}
			}
		}

	}
}