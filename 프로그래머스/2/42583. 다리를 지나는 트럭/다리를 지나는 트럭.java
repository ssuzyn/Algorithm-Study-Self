import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {Queue<Integer> waitedT = new LinkedList<>();
    	Queue<Integer> bridgeT = new LinkedList<>();
    	
    	for(int truck : truck_weights) {
    		waitedT.offer(truck);
    	}
    	
    	int sum = 0; //현재 다리 중량
    	int minute = 0; //전체 경과 시간
    	int completeCount = 0; //다리를 지난 트럭수
    	
    	while(completeCount != truck_weights.length) {
    		minute++;
    		
    		if(bridgeT.size() == bridge_length) {
    			int tmpTruck = bridgeT.poll();
    			if(tmpTruck != 0) {
    				completeCount++;
    				sum -= tmpTruck;
    			}
    		}
    		
    		if(waitedT.peek() != null) {
    			if(sum + waitedT.peek() > weight) {
    				bridgeT.offer(0);
        		}
        		
        		if(sum + waitedT.peek() <= weight) {
        			int tmpTruck = waitedT.poll();
        				
            	    bridgeT.offer(tmpTruck);
            		sum += tmpTruck;
        		}
    		}
    		else bridgeT.offer(0);
    		
    	}
    	
    	return minute;
    }
}