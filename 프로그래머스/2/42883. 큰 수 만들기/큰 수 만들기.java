import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < number.length(); i++){
            char tmp = number.charAt(i);
            
            while(count < k && !stack.isEmpty() && stack.peek() < tmp){
                stack.pop(); // 숫자 제거
                count++;
            }
            
            stack.push(tmp);
        }
        
        // k개를 모두 제거하지 못한 경우 뒤에서 제거
        while(count < k) {
            stack.pop();
            count++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){ // stack을 앞에서부터 순서대로 읽음
            sb.append(c);
        }
        return sb.toString();
    }
}