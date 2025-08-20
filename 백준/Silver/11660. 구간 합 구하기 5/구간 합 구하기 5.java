import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] sum = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++){
				int tmp = Integer.parseInt(st.nextToken());
				sum[i][j] += tmp + sum[i - 1][j] + sum[i][j - 1] - sum[i-1][j-1];
			}
		}

		StringBuilder sb = new StringBuilder();
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int answer = sum[x2][y2] + sum[x1-1][y1-1] - sum[x1-1][y2] - sum[x2][y1-1];
			sb.append(answer).append("\n");
		}

		System.out.print(sb);
	}

}