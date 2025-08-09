import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[] newbie = new int[N];

			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				newbie[a-1] = b;
			}

			int answer = 1;
			int max = newbie[0]; // 1차 성적 기준 1등 신입사원의 2차 성적
			for(int i = 1; i < N; i++){
				if(max > newbie[i]){
					max = newbie[i];
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

}