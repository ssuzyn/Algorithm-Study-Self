import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, minPrice, minBit;
    static int[] minNutrient;
    static int[][] food;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minNutrient = new int[4];
        food = new int[N][5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minNutrient[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minBit = 0;
        minPrice = Integer.MAX_VALUE;
        pick(0, new int[4], 0, 0);

        if (minPrice == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minPrice);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if ((minBit & (1 << i)) != 0) {
                    sb.append(i + 1).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static boolean isFit(int[] arr) { // 최소 영양분 조건을 만족하는지 확인
        for (int i = 0; i < 4; i++) {
            if (arr[i] < minNutrient[i]) {
                return false;
            }
        }
        return true;
    }

    private static void pick(int idx, int[] totalN, int price, int bits) {
        if(price > minPrice) return;

        // 영양소 조건 만족 시 최적 해 갱신
        if (isFit(totalN)) {
            if (price < minPrice) {
                minPrice = price;
                minBit = bits;
            }
        }

        // 종료 조건
        if (idx == N) return;

        // idx 번째 재료 선택 O
        int[] nextTotal = totalN.clone();
        for (int i = 0; i < 4; i++) nextTotal[i] += food[idx][i];
        pick(idx + 1, nextTotal, price + food[idx][4], bits | (1 << idx));

        // idx 번째 재료 선택 X
        pick(idx + 1, totalN, price, bits);
    }
}
