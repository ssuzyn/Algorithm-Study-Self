import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		
            if(c == '(') count++;
            else if(c == ')') count--;
            
            if(count < 0) break;
        }
        
        if(count == 0) return true;
        return answer;
    }
}