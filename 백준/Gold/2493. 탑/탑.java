import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			int curHeight = heights[i];

			// 스택에서 현재 탑보다 낮은 탑 제거
			while(!stack.isEmpty() && stack.peek()[1] < curHeight) {
				stack.pop();
			}

			if(stack.isEmpty()) sb.append("0 "); // 왼쪽에 레이저 받는 탑 없음
			else sb.append(stack.peek()[0] + 1).append(" "); // 왼쪽에 레이저 받는 탑 존재

			stack.push(new int[]{i, curHeight}); // 현재 탑 스택에 추가
		}

		System.out.println(sb);
	}
}
