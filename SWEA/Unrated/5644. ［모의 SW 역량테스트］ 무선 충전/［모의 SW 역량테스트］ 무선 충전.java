import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int M, count, maxCharge;
    static BC[] BCs;
    static int[] distA, distB;

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dir){
            switch(dir){
                case 1: y--; break; // 상
                case 2: x++; break; // 우
                case 3: y++; break; // 하
                case 4: x--; break; // 좌
            }
        }
    }

    static class BC {
        Point point; // 위치
        int C; // 충전 범위
        int P; // 성능

        BC(Point point, int C, int P) {
            this.point = point;
            this.C = C;
            this.P = P;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 이동 시간
            count = Integer.parseInt(st.nextToken()); // BC의 개수

            distA = new int[M]; // 사용자 A의 이동 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                distA[i] = Integer.parseInt(st.nextToken());
            }

            distB = new int[M]; // 사용자 B의 이동 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                distB[i] = Integer.parseInt(st.nextToken());
            }

            BCs = new BC[count];
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                BCs[i] = new BC(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            maxCharge = 0;
            solution();
            System.out.println("#" + t + " " + maxCharge);

        }
    }

    private static void solution() {
        Point A = new Point(1, 1);
        Point B = new Point(10, 10);

        charge(A, B);

        for(int time = 0; time < M; time++) {
            A.move(distA[time]);
            B.move(distB[time]);
            charge(A, B);
        }
    }

    private static void charge(Point userA, Point userB) {
        List<Integer> listA = checkRange(userA);
        List<Integer> listB = checkRange(userB);

        int max = 0;
        // A와 B 모두 접속 가능한 BC가 1개 이상인 경우
        if(listA.size() > 0 && listB.size() > 0) {
            for(int i : listA){
                for(int j : listB){
                    int tmp = 0;
                    if(i == j){ // 같은 BC인 경우 분배하므로 한번만 더하기
                        tmp += BCs[i].P;
                    }
                    else{ // 다른 BC인 경우 각각 처리량 더하기
                        tmp += BCs[i].P;
                        tmp += BCs[j].P;
                    }
                    max = Math.max(max, tmp);
                }
            }
        }
        else if(listA.size() > 0){ // A가 접속 가능한 BC가 1개 이상인 경우
            for(int i : listA){
                max = Math.max(max, BCs[i].P);
            }
        }
        else if(listB.size() > 0){ // B가 접속 가능한 BC가 1개 이상인 경우
            for(int i : listB){
                max = Math.max(max, BCs[i].P);
            }
        }

        maxCharge += max;
    }

    private static List<Integer> checkRange(Point user){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < BCs.length; i++) {
            if(Math.abs(user.x - BCs[i].point.x) + Math.abs(user.y - BCs[i].point.y) <= BCs[i].C)
                list.add(i);
        }
        return list;
    }

}
