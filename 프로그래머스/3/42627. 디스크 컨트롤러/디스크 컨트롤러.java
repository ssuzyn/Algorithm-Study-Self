import java.util.*;

class Solution {
    private class Job{
		int request;
		int duration;
		
		Job(int request, int duration){
			this.request = request;
			this.duration = duration;
		}
	}
	
    public int solution(int[][] jobs) {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.request));
        PriorityQueue<Job> processingQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.duration));

        
        for(int[]job : jobs) {
        	jobQueue.offer(new Job(job[0], job[1]));
        }
        
        int jobCount = jobQueue.size();
        int currentTime = 0;
        int totalWaitingTime = 0;
        
        while(!jobQueue.isEmpty() || !processingQueue.isEmpty()) {
        	while(!jobQueue.isEmpty() && jobQueue.peek().request <= currentTime) {
        		processingQueue.offer(jobQueue.poll());
        	}
        	
        	
        	if(!processingQueue.isEmpty()) {
        		Job job = processingQueue.poll();
        		currentTime += job.duration;
        		totalWaitingTime += currentTime - job.request;
        	}
        	else if(!jobQueue.isEmpty()) {
        		currentTime = jobQueue.peek().request;
        	}
        }
        
        
        return totalWaitingTime / jobCount;
    }
}