import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int start;
    static boolean[] check;
    static ArrayList<Integer>[] phoneCall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {  // 테스트 케이스는 10개
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 데이터 길이
            start = Integer.parseInt(st.nextToken()); // 비상연락망 시작 번호

            check = new boolean[101];  // 연락된 사람을 추적하는 배열
            phoneCall = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                phoneCall[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (!phoneCall[from].contains(to)) {
                    phoneCall[from].add(to);  // 중복된 연결은 저장하지 않음
                }
            }

            int result = bfs();
            System.out.println("#" + t + " " + result);
        }
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);
        int maxNumber = start;

        while (!q.isEmpty()) {
            int size = q.size();
            int currentMax = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : phoneCall[cur]) {
                    if (!check[next]) {
                        check[next] = true;
                        q.add(next);
                        currentMax = Math.max(currentMax, next);  // 현재 레벨에서 가장 큰 번호 추적
                    }
                }
            }

            if (currentMax != 0) {
                maxNumber = currentMax;  // 현재 레벨에서 가장 큰 번호가 있을 경우 업데이트
            }
        }

        return maxNumber;
    }
}
