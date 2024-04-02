import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(String op : operations) {
        	
        	String command = op.split(" ")[0];
        	int num = Integer.parseInt(op.split(" ")[1]);
        	
        	if(command.equals("I")) {
        		queue.offer(num);
        	}
        	
        	if(command.equals("D") && !queue.isEmpty()) {
        		if(num == 1) {
        			queue.poll();
        		}
        		else {
        			PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        			minQueue.addAll(queue);
        			minQueue.poll();
        			queue.clear();
        			queue.addAll(minQueue);
        		}
        	}
        }
        

        if(queue.isEmpty()) {
        	return new int[] {0, 0};
        }
        else {
        	int max = queue.poll();
        	int min = Collections.min(queue);
        	return new int[] {max, min};
        }
    }
}