import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] dp;
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	dp = new int[N + 1];
    	
    	for(int i = 2; i < N + 1; i++) {
    		
    		// 현재의 수에서 1을 빼는 경우
    		dp[i] = dp[i-1] + 1;
    		
    		// 현재의 수가 2로 나누어 떨어지는 경우
    		if(i % 2 == 0)
    			dp[i] = Math.min(dp[i], dp[i/2] + 1);

    		// 현재의 수가 3로 나누어 떨어지는 경우
    		if(i % 3 == 0)
    			dp[i] = Math.min(dp[i], dp[i/3] + 1);
    	}
    	
    	System.out.println(dp[N]);
    	
    }
}