import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X, M;
	static int maxHamster;
	static int[] cage;
	static int[][] record;
	static int[] answer;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 햄스터 우리 
			X = Integer.parseInt(st.nextToken()); // 각 우리 최대 햄스터 마리수 
			M = Integer.parseInt(st.nextToken()); // 경근이의 기록 개수 
			cage = new int[N]; // 순열을 위한 배열 
			answer = new int[N]; // 최종 결과 저장 
			record = new int[M][3]; // 경근이 기록 저장
			maxHamster = Integer.MIN_VALUE;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				record[i][0] = Integer.parseInt(st.nextToken()) - 1; // 시작 우리 
				record[i][1] = Integer.parseInt(st.nextToken()) - 1; // 끝 우리 
				record[i][2] = Integer.parseInt(st.nextToken()); // 햄스터 총 마리수 
			}
			
			perm(0);

			sb.append("#" + t + " ");
			if(maxHamster == Integer.MIN_VALUE) {
				sb.append(-1);
			}
			else {
				for(int i = 0; i < N; i++) {
					sb.append(answer[i] + " ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
	
	private static void perm(int idx) {
		if(idx == N) {
			for(int i = 0; i < M; i++) {
				int I = record[i][0]; // 시작 우리 
				int R = record[i][1]; // 끝 우리 
				int S = record[i][2]; // 햄스터 총 마리수 
				
				int sum = 0;
				for(int j = I; j <= R; j++) {
					sum += cage[j];
				}
				if(sum != S) return;
			}
			
			int total = 0;
			for(int i = 0; i < N; i++) {
				total += cage[i];
			}
			
			if(total > maxHamster) {
				maxHamster = total;
				answer = Arrays.copyOf(cage, N);
			}
			
			return;
		}
		
		for(int i = 0; i <= X; i++) {
			cage[idx] = i;
			perm(idx + 1);
		}
	}
}