import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> players = new HashMap<>();

        for(String name : participant){ // 참여한 선수 명단 -> 동명이인 고려를 위해 HashMap 사용
            players.put(name, players.getOrDefault(name, 0) + 1);
        }

        for(String name: completion){
            players.put(name, players.get(name) - 1);
        }

        for(String name: players.keySet()){
            if(players.get(name) == 1) answer = name;
        }

        return answer;
    }
}