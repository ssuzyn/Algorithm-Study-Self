import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
	boolean[] visit;
	
	
	public void dfs(int index) {
		visit[index] = true;
		
		for(int next: graph[index]) {
			if(!visit[next]) {
				dfs(next);
			}
		}
	}
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList[n];
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(computers[i][j] == 1) {
        			graph[i].add(j);
        			graph[j].add(i);
        		}
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	if(!visit[i]) {
        		answer++;
            	dfs(i);
        	}
        }
        
        return answer;
    }
}