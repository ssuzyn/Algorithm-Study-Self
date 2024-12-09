class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long)times[0] * n; // 최악의 시간 고려

        while(left < right){
            long mid = (left + right) / 2;
            long sum = 0; // mid분 동안 처리할 수 있는 사람 수

            for(int time: times){
                sum += mid / time;
            }

            if(sum >= n) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}