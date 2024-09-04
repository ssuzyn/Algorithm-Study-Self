import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static long ans;
	static int[][] earthworm;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			earthworm = new int[N][2];
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				earthworm[i][0] = Integer.parseInt(st.nextToken()); // x좌표
				earthworm[i][1] = Integer.parseInt(st.nextToken()); // y좌표
			}
			
			ans = Long.MAX_VALUE;
			date(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
		

	}
	
	static void date(int cnt, int start) {
		if(cnt == N/2) { // 모든 지렁이 매칭 완료
			
			long[] v1 = {0, 0};
			long[] v2 = {0, 0};
			for(int i = 0; i < N; i++) {
			    if (visited[i]) {
			        v1[0] += earthworm[i][0];
			        v1[1] += earthworm[i][1];
			    }
			    else {
			    	 v2[0] += earthworm[i][0];
				     v2[1] += earthworm[i][1];
			    }
			}
			
			long x = v1[0] - v2[0];
			long y = v1[1] - v2[1];
			ans = Math.min(ans, x * x + y * y);
			return;

		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			date(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
	

}
