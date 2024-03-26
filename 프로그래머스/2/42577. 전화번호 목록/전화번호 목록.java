import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            String prefix = phone_book[i];
            String tmp = phone_book[i+1];
            
            if(tmp.startsWith(prefix)) {
                return false;
            }
        }
        
        return true;
    }
}