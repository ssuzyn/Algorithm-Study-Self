import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int carpetSize = brown + yellow;
        int width = 0, length = 0;
        
        List<Integer> numbers = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(carpetSize); i++){
            if(carpetSize % i == 0){
                numbers.add(i);
            }
        }
        
        for(int num : numbers){
            int tmp = carpetSize / num;
            if(((num-2) * (tmp-2)) == yellow) {
            	width = Math.max(tmp, num);
                length = Math.min(tmp, num);
            }
        }
        
        return new int[] {width, length};
    }
}