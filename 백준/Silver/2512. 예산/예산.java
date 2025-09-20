import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] request = new int[N];
		int maxRequest = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			request[i] = Integer.parseInt(st.nextToken());
			maxRequest = Math.max(request[i], maxRequest);
		}

		int total = Integer.parseInt(br.readLine());
		int left = 0;
		int right = maxRequest;
		int answer = 0;

		while(left <= right){
			int mid = (left + right) / 2;
			int sum = 0;

			for(int i = 0; i < N; i++){
				sum += Math.min(request[i], mid);
			}

			if(sum <= total){
				answer = mid;
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
