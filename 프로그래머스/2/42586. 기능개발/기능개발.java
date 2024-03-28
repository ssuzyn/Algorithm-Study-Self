import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        List<Integer> complete = new LinkedList<>();
    	List<Integer> answer = new ArrayList<>();
    	
    	for(int i = 0; i < progresses.length; i++) {
    		int remain = 100 - progresses[i];
    		int day = remain / speeds[i];
    		
    		if(remain % speeds[i] != 0) day += 1;
    		complete.add(day);
    	}
    	
    	int count = 1;
    	int day = complete.get(0);
    	for(int i = 1; i < complete.size(); i++) {
    		
    		if(complete.get(i) <= day) {
    			count++;
    		}
    		else {
    			day = complete.get(i);
        		answer.add(count);
    			count = 1;
    		}
    	}
        answer.add(count);
    	
        return answer;
    }
}