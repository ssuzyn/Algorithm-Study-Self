import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N, cost, answer;
    static int[][] map;
    static ArrayList<int[]> house;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도시 크기
            cost = Integer.parseInt(st.nextToken()); // 지불 비용
            map = new int[N][N];
            house = new ArrayList<>();
            answer = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) house.add(new int[]{i, j}); // 집 위치 저장
                }
            }

            homeService();
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static void homeService(){
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 1; k <= N+1; k++) {
                    int loss = calcOperatingCost(k); // 운영 비용
                    int serviceHome = 0; // 서비스 제공 받는 집

                    for(int[] home : house){
                        int x = home[0];
                        int y = home[1];

                        if(getDistance(i, j, x, y) < k) serviceHome++;
                    }

                    if(serviceHome * cost - loss >= 0){ // 보안회사가 손해보지 않는 경우
                        answer = Math.max(answer, serviceHome);
                    }
                }

            }
        }
    }

    static int getDistance(int i, int j, int x, int y){
        return Math.abs(i - x) + Math.abs(j - y);
    }

    static int calcOperatingCost(int k){
        return k * k + (k - 1) * (k - 1);
    }
}
