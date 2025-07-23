class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < size; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0) dp[i][j] = triangle[i][j] + dp[i-1][j];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < size; i++){
            if(answer < dp[size-1][i]) answer = dp[size-1][i];
        }
        
        return answer;
    }
}