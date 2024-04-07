import java.util.*;

class Solution {
    char[] WORD = {'A', 'E', 'I', 'O', 'U'};
	int LENGTH = 5;
	
	public void dfs(List<String> element, String tmp){
		
		if(tmp.length() > LENGTH) return;
		
		if(!element.contains(tmp)) element.add(tmp);
		
		for(int i = 0; i < WORD.length; i++) {
			dfs(element, tmp + WORD[i]);
		}
	}
	
    public int solution(String word) {

    	List<String> element = new ArrayList<>();
    	
    	for(int i = 0; i < WORD.length; i++) {
    		dfs(element, String.valueOf(WORD[i]));
    	}
        
        return element.indexOf(word) + 1;
    }
}