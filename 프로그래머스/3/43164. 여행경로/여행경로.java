import java.util.*;

class Solution {
    boolean [] visit;
    List<String> result = new ArrayList<>();
    
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        
        return result.get(0).split(" ");
        
    }
    
    private void dfs(int depth, String now, String path, String[][] tickets) {
    	if(depth == tickets.length) {
    		result.add(path);
    		return;
    	}
    	
    	for(int i = 0; i < tickets.length; i++) {
    		if(!visit[i] && tickets[i][0].equals(now)) {
    			visit[i] = true;
    			dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
    			visit[i] = false;
    		}
    	}
    }
}