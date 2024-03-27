import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesCase = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String tmp = clothes[i][1];
            clothesCase.put(tmp, clothesCase.getOrDefault(tmp, 0) + 1);
        }
        
        int answer = 1;
        for(String key : clothesCase.keySet()){
            answer *= (clothesCase.get(key) + 1);
        }
        
        return answer - 1;
    }
}