import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, minCost = Integer.MAX_VALUE, minIdx;
	static int[] minNutrients;
	static int[][] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minNutrients = new int[4];
		ingredients = new int[N][5];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++){
			minNutrients[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++){
				ingredients[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pick(0, 0, 0, 0, 0, 0, 0);

		if(minCost == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			StringBuilder sb = new StringBuilder();
			sb.append(minCost).append('\n');
			for(int i = 0; i < N; i++) {
				if ((minIdx & (1 << i)) != 0) {
					sb.append(i + 1).append(' ');
				}
			}
			System.out.println(sb);
		}
	}

	private static void pick(int idx, int cost, int bits, int p, int f, int c, int v){
		if(cost >= minCost) return;

		// 영양소 조건 확인
		if(p >= minNutrients[0] && f >= minNutrients[1] &&
			c >= minNutrients[2] && v >= minNutrients[3]){
			if(cost < minCost){
				minCost = cost;
				minIdx = bits;
			}
		}

		if(idx == N) return;

		// 현재 재료 선택
		pick(idx + 1, cost + ingredients[idx][4], bits | (1 << idx),
			p + ingredients[idx][0], f + ingredients[idx][1],
			c + ingredients[idx][2], v + ingredients[idx][3]);

		// 현재 재료 선택 안함
		pick(idx + 1, cost, bits, p, f, c, v);
	}
}