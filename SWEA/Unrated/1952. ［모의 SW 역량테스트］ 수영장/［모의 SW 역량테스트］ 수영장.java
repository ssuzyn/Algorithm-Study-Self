import java.util.Scanner;


public class Solution {

    static int minCost;
    static int day, month, threeMonths, year;
    static int[] plan = new int[12+1];

    // 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용을 구하는 문제이다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
        
            day = sc.nextInt();
            month = sc.nextInt();
            threeMonths = sc.nextInt();
            year = sc.nextInt();

            for (int i = 1; i <= 12; i++) {
                plan[i] = sc.nextInt();
            }

            minCost = year;
            getMinimumCost(1, 0);
        

            System.out.println("#" + t + " " + minCost);
        }


    }

    private static void getMinimumCost(int idx, int sum) {

        if (minCost < sum) {
            return;
        }

        if (idx > 12) { 
            minCost = sum; // 위 가지치기로 인해 무조건 ans > sum
            return;
        }

        if (plan[idx] == 0) {
            getMinimumCost(idx + 1, sum); 
            return;
        }

        
        getMinimumCost(idx + 1, sum + plan[idx] * day);
        getMinimumCost(idx + 1, sum + month); //한달치
        getMinimumCost(idx + 3, sum + threeMonths); //세달치

    }
}
