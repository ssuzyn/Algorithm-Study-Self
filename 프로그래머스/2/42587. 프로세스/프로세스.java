import java.util.*;

class Solution {
    private class Process {
		int index;
		int priority;
		
		Process(int index, int priority){
			this.index = index;
			this.priority = priority;
		}
		
	}
	
    public int solution(int[] priorities, int location) {
    	int answer = 1;
    	
    	ArrayDeque<Process> deq = new ArrayDeque<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

    	
    	for(int i = 0; i < priorities.length; i++) {
    		deq.offerLast(new Process(i, priorities[i]));
    		q.offer(priorities[i]);
    	}
    	
    	while(!deq.isEmpty()) {
    		Process currentP = deq.pollFirst();
    		
    		if(q.peek() > currentP.priority) {
    			deq.offerLast(currentP);
    		}
    		else {
    			q.poll();
    			if(currentP.index == location) break;
    			else answer++;
    		}
    	}
    	
    	return answer;
    }
}