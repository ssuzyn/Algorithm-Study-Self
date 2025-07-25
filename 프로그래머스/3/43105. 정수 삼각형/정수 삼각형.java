class Solution {
    public int solution(int[][] triangle) {
        
        for(int i = triangle.length - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i+1][j+1], triangle[i+1][j]);
            }
        }
        
        return triangle[0][0];
    }
}