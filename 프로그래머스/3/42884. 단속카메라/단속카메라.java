import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        
        int out = routes[0][1]; // 첫 차량의 진출시점
        
        for(int i = 1; i < routes.length; i++){
            if(out < routes[i][0]) {
                answer++;
                out = routes[i][1];
            }
            if(out > routes[i][1]){
                out = routes[i][1];
            }
        }
        
        return answer;
    }
}