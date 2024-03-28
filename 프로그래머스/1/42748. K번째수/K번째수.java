import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> result = new ArrayList<>();
        
        for(int[] command : commands){
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;
            
            int[] tmp = Arrays.copyOfRange(array, i, j);
            Arrays.sort(tmp);
            result.add(tmp[k]);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}