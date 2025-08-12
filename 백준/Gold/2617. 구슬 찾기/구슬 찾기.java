import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 구슬의 개수
		int M = Integer.parseInt(st.nextToken()); // 구슬 쌍

		boolean[][] heavier = new boolean[N][N]; // heavier[i][j] = i가 j보다 무겁다?

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			// a가 b보다 무겁다
			heavier[a][b] = true;
		}

		// 플로이드 워샬로 간접적인 관계 추론
		for(int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(heavier[i][k] && heavier[k][j]){
						heavier[i][j] = true; // i > k > j
					}
				}
			}
		}

		int count = 0;
		for(int i = 0; i < N; i++){
			int heavyCount = 0; // i보다 무거운 구술 개수
			int lightCount = 0; // i보다 가벼운 구슬 개수

			for(int j = 0; j < N; j++){
				if(heavier[i][j]) lightCount++;
				if(heavier[j][i]) heavyCount++;
			}
			if(heavyCount > N / 2 || lightCount > N / 2){
				count++;
			}
		}

		System.out.println(count);
	}

}
