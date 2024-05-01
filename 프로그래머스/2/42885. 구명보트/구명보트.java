import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int count = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 두 사람을 함께 보내고, 양쪽 인덱스를 조정
                i++;
            }
            // 가장 무거운 사람을 보냄
            j--;
            count++;
        }

        return count;
    }
}
