class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        
        for(int[] tmp : puddles){
            map[tmp[0]][tmp[1]] = -1;
        }
        
        map[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == -1) continue;
                
                if(map[i-1][j] > 0) map[i][j] = (map[i][j] + map[i-1][j]) % 1000000007;
                if(map[i][j-1] > 0) map[i][j] = (map[i][j] + map[i][j-1]) % 1000000007;
            }
        }
        
        return map[m][n];
    }
}