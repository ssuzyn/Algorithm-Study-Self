import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 건물의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		dist = new int[N + 1][N + 1];

		for(int i = 1; i <= N; i++){
			Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
			dist[i][i] = 0;
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = dist[b][a] = 1;
		}

		for(int k = 1; k <= N; k++){
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		int x = 0, y = 0;
		for(int a = 1; a < N; a++){
			for(int b = a + 1; b <= N; b++){
				int sum = 0;

				for(int city = 1; city <= N; city++){
					int minDist = Math.min(dist[city][a], dist[city][b]);
					sum += minDist * 2; // 왕복 거리 합산

					if(answer < sum) break;
				}

				if(answer > sum){
					answer = sum;
					x = a;
					y = b;
				}
			}
		}

		System.out.println(x + " " + y + " " + answer);
	}

}