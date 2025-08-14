import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] water = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			water[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N-1;
		int minDiff = Integer.MAX_VALUE;
		int[] answer = new int[2];

		while(left < right){
			int diff = water[left] + water[right];
			if(minDiff > Math.abs(diff)){
				minDiff = Math.abs(diff);
				answer[0] = water[left];
				answer[1] = water[right];
			}

			if(diff > 0) right--;
			else left++;
		}

		System.out.println(answer[0] + " " + answer[1]);
	}

}