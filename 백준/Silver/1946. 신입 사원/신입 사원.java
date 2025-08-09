import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[][] newbie = new int[N][2];

			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				newbie[i][0] = Integer.parseInt(st.nextToken());
				newbie[i][1] = Integer.parseInt(st.nextToken());
			}

			// 1차 성적 기준으로 정렬
			Arrays.sort(newbie, (n1, n2) -> n1[0] - n2[0]);

			int answer = 1;
			int max = newbie[0][1]; // 1차 성적 기준 1등 신입사원의 2차 성적
			for(int i = 1; i < N; i++){
				if(max > newbie[i][1]){
					max = newbie[i][1];
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

}