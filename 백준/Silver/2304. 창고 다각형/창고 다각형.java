import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int start = Integer.MAX_VALUE;
		int end = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			start = Math.min(L, start);
			end = Math.max(L, end);
		}

		// 기둥의 높이를 저장하는 스택
		Stack<Integer> stack = new Stack<>();

		// 왼쪽 기둥 비교
		int maxHeight = arr[start];
		for(int i = start + 1; i <= end; i++){
			if(arr[i] < maxHeight) stack.push(i);
			else{
				while(!stack.isEmpty()){
					int idx = stack.pop();
					arr[idx] = maxHeight;
				}
				maxHeight = arr[i];
			}
		}
		stack.clear();

		// 오른쪽 기둥 비교
		maxHeight = arr[end];
		for(int i = end - 1; i >= start; i--){
			if(arr[i] < maxHeight) stack.push(i);
			else{
				while(!stack.isEmpty()){
					int idx = stack.pop();
					arr[idx] = maxHeight;
				}
				maxHeight = arr[i];
			}
		}

		int answer = 0;
		for(int i = start; i <= end; i++){
			answer += arr[i];
		}

		System.out.println(answer);
	}

}