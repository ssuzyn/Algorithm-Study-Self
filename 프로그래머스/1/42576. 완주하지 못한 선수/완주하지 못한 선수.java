import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> player = new HashMap<>();
        
        for(String name: participant){
            if(player.containsKey(name)) {
                player.put(name, player.get(name) + 1);
            }
            else{
                player.put(name, 1);

            }
        }
        
        for(String name: completion){
            if(player.containsKey(name)){
                player.replace(name, player.get(name) - 1);
            }
        }
        
        String answer = "";
        for(String name : player.keySet()){
            if(player.get(name) == 1) answer = name;
        }
        
        return answer;
    }
}