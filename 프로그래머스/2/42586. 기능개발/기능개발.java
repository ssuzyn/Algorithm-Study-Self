import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
    	List<Integer> answer = new ArrayList<>();
    	
    	for(int i = 0; i < progresses.length; i++) {
    		
    		double remain = (100 - progresses[i]) / (double)speeds[i];
    		int date = (int) Math.ceil(remain);
    		
    		if(!q.isEmpty() && q.peek() < date) {
    			answer.add(q.size());
    			q.clear();
    		}
    		q.offer(date);
    	}
    	
    	answer.add(q.size());
    	
        return answer;
    }
}