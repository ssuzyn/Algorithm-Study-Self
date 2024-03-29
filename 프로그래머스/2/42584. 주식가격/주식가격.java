import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Queue<Integer> priceQ = new LinkedList<>();
        
        for(int p : prices){
            priceQ.offer(p);
        }
        
        int index = 0;
        while(!priceQ.isEmpty()){
            int tmpPrice = priceQ.poll();
            answer[index] = 0;
            
            for(Integer next : priceQ){
                answer[index]++;
                if(tmpPrice > next) break;
            }
            
            index++;
        }
        
        return answer;
    }
}