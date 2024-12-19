import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        // 각 열의 최소/최대값을 저장할 배열
        int[] min = new int[3];
        int[] max = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            min[i] = max[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            // 새로운 최대, 최소값을 저장할 임시 배열
            int[] new_max = new int[3];
            int[] new_min = new int[3];

            // [0]열 처리
            int num = Integer.parseInt(st.nextToken());
            int tmp_max = Math.max(max[0], max[1]);
            int tmp_min = Math.min(min[0], min[1]);
            new_max[0] = tmp_max + num;
            new_min[0] = tmp_min + num;

            // [1]열 처리
            num = Integer.parseInt(st.nextToken());
            tmp_max = Math.max(Math.max(max[0], max[1]), max[2]);
            tmp_min = Math.min(Math.min(min[0], min[1]), min[2]);
            new_max[1] = tmp_max + num;
            new_min[1] = tmp_min + num;

            // [2]열 처리
            num = Integer.parseInt(st.nextToken());
            tmp_max = Math.max(max[1], max[2]);
            tmp_min = Math.min(min[1], min[2]);
            new_max[2] = tmp_max + num;
            new_min[2] = tmp_min + num;

            // 다음 행 계산을 위해 배열 업데이트
            max = new_max;
            min = new_min;
        }

        System.out.println(Math.max(Math.max(max[0], max[1]), max[2])
            + " " + Math.min(Math.min(min[0], min[1]), min[2]));
    }
}
