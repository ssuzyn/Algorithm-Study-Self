import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        List<HashSet<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i <= 8; i++){
            bucket.add(new HashSet<Integer>());
        }
        bucket.get(1).add(N); // 숫자 N을 1개 사용하는 경우는 자기자신 뿐
        
        if(number == N) return 1;
        
        for(int i = 2; i<= 8; i++){
            HashSet<Integer> total = bucket.get(i);
            
            for(int j = 1; j < i; j++){
                HashSet<Integer> a = bucket.get(j);
                HashSet<Integer> b = bucket.get(i - j);
                
                for(int x : a){
                    for(int y : b){
                        total.add(x + y);
                        total.add(x - y);
                        total.add(x * y);
                        if(x != 0 && y != 0) total.add(x/y);
                    }
                }
            }
            
            total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            if(total.contains(number)) return i;
        }
        
        return answer;
    }
}