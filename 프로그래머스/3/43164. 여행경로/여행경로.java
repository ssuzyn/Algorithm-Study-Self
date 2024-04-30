import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket: tickets){
            
            String key = ticket[0];
            if(!graph.containsKey(key)){
                graph.put(key, new PriorityQueue<>());
            }
            
            graph.get(key).offer(ticket[1]);
        }
        
        
        return dfs(new ArrayList<>(), "ICN").toArray(new String[0]);
    }
    
    public List<String> dfs(List<String> answer, String key){
        if(!graph.containsKey(key) || graph.get(key).isEmpty()){
            answer.add(key);
            return answer;
        }
        
        answer.add(key);
        
        List<String> right = dfs(new ArrayList<>(), graph.get(key).poll());
        
        if(!graph.get(key).isEmpty()){
            List<String> left = dfs(new ArrayList<>(), graph.get(key).poll());
            answer.addAll(left);
        }
        
        answer.addAll(right);
        
        return answer;
    }
}