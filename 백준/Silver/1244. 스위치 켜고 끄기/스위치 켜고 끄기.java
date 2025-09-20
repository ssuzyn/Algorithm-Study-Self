import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] light;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		light = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			light[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if(gender == 1) switchByMale(num);
			else switchByFemale(num);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++){
			sb.append(light[i] + " ");

			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void switchByMale(int num){
		for(int i = num; i <= N; i+=num){
			light[i] = 1 - light[i];
		}
	}

	private static void switchByFemale(int num){
		light[num] = 1 - light[num];
		int left = num - 1;
		int right = num + 1;

		while(1 <= left && right <= N){
			if(light[left] != light[right]){
				break;
			}
			else{
				light[left] = 1 - light[left];
				light[right] = 1 - light[right];
				left--;
				right++;
			}
		}
	}

}