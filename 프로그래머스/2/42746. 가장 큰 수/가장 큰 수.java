import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<String> str = new ArrayList<>();
    	for(int num: numbers) {
    		str.add(String.valueOf(num));
    	}
    	
        str.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(str.get(0).equals("0")) return "0";
        
        String answer = "";
        for(String num : str){
            answer += num;
        }
        return answer;
    }
}