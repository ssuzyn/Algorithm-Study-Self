import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] number;
	static int[] operator;
	static int answerMax = Integer.MIN_VALUE;
	static int answerMin = Integer.MAX_VALUE;
	
	public static void dfs(int sum, int idx) {
		if(idx == N) {
			answerMax = Math.max(sum, answerMax);
			answerMin = Math.min(sum, answerMin);
		}
		
		for(int i = 0; i < operator.length; i++) {
			if(operator[i] > 0) {
				
				operator[i]--;
				switch(i) {
				case 0: dfs(sum + number[idx], idx + 1); break;
				case 1: dfs(sum - number[idx], idx + 1); break;
				case 2: dfs(sum * number[idx], idx + 1); break;
				case 3: dfs(sum / number[idx], idx + 1); break;
				}
				operator[i]++;
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0], 1);
		System.out.println(answerMax);
		System.out.println(answerMin);

		
	}

}
