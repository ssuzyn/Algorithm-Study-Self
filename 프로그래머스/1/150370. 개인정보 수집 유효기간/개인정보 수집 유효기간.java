import java.util.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        List<Integer> result = new ArrayList<>();
        String[] todayInput = today.split("\\.");
		int todayY = Integer.parseInt(todayInput[0]);
		int todayM = Integer.parseInt(todayInput[1]);
		int todayD = Integer.parseInt(todayInput[2]);
        int todayTotal = todayY*12*28 + todayM*28 + todayD;
	
        
        Map<String, Integer>termsMap = new HashMap();
        for(int i = 0; i < terms.length; i++){
            String[] input = terms[i].split(" ");
            termsMap.put(input[0], Integer.parseInt(input[1]));
        }
        
        
        for(int i = 0; i < privacies.length; i++){
            String[] tmp = privacies[i].split(" ");
            String[] date = tmp[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            String type = tmp[1];
            
            int sum = month + termsMap.get(type);
            int tmpTotal;
            
            if(sum > 12){
                tmpTotal = (year + sum/12)*12*28 + (sum%12)*28 + day-1;
            }
            else{
                tmpTotal = year*12*28 + sum*28 + day-1;
            }
    		
            if(tmpTotal < todayTotal){
                result.add(i+1);
            }
            
        }
        
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}