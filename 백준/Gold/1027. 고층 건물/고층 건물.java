import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			h[i] = Integer.parseInt(st.nextToken());
		}

		int maxVisible = 0;

		for(int i = 0; i < N; i++){
			int visible = 0;

			// 왼쪽 방향 - 기울기가 계속 감소해야 함
			double leftSlope = Double.POSITIVE_INFINITY;
			for(int j = i - 1; j >= 0; j--){
				double slope = (double)(h[j] - h[i]) / (j - i);
				if(slope < leftSlope){
					visible++;
					leftSlope = slope;
				}
			}

			// 오른쪽 방향 - 기울기가 계속 증가해야 함
			double rightSlope = Double.NEGATIVE_INFINITY;
			for(int j = i + 1; j < N; j++){
				double slope = (double)(h[j] - h[i]) / (j - i);
				if(slope > rightSlope){
					visible++;
					rightSlope = slope;
				}
			}

			maxVisible = Math.max(maxVisible, visible);
		}

		System.out.println(maxVisible);
	}
}