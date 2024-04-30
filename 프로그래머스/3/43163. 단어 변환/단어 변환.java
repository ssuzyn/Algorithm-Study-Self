import java.util.*;

class Solution {
    String[] words;
	String target;
	boolean[] visit;
	int answer;
    
    public int solution(String begin, String target, String[] words) {
    	
        this.words = words;
        this.target = target;
        this.visit = new boolean[words.length];
        this.answer = Integer.MAX_VALUE;
        
        
        boolean targetInWords = Arrays.asList(words).contains(target);
        if(!targetInWords) return 0;
        
        dfs(begin, 0);
        
        return answer;
    }
	
	public boolean isValid(String word1, String word2) {
		int diff = 0;
		
		for (int i = 0; i < word2.length(); i++) {
		    if (word2.charAt(i) != word1.charAt(i)) {
		    	diff++;
			    if(diff > 1) return false;
		    }
		}
		
		return true;
	}
	
	
	public void dfs(String current, int step) {
		
		if(current.equals(target)) {
			answer = Math.min(answer, step);
			return;
		}
		
		for(int i = 0; i < words.length; i++) {
			if(!visit[i] && isValid(current, words[i])) {
				System.out.println(current + " -> " + words[i]);
				visit[i] = true;
				dfs(words[i], step + 1);
				visit[i] = false;
			}
		}
		
	}
	
}