import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1)); // 재생 횟수 기준 내림차순 정렬

        List<Integer> res = new ArrayList<>();
        for(String key : keySet){
            HashMap<Integer, Integer> tmpMap = new HashMap<>();

            for(int i = 0; i < genres.length; i++){ // 현재 key에 해당하는 장르의 재생 목록 가져오기
                if(genres[i].equals(key)) tmpMap.put(i, plays[i]);
            }

            List<Integer> tmpKeys = new ArrayList<>(tmpMap.keySet());
            if(tmpKeys.size() == 1){ // 장르에 속한 곡이 하나라면, 하나만 선택
                res.add(tmpKeys.get(0));
                continue;
            }
            tmpKeys.sort((o1, o2) -> tmpMap.get(o2) - tmpMap.get(o1));

            res.add(tmpKeys.get(0));
            res.add(tmpKeys.get(1));
        }

        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}