import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, weight;
    static int[] snack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 과자 개수
            M = Integer.parseInt(st.nextToken()); // 무게 합 제한
            snack = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }

            weight = -1;
            pickSnack();
            System.out.println("#" + t + " " + weight);
        }
    }

    private static void pickSnack(){
        int start = 0, end = N-1;
        Arrays.sort(snack);

        while(start < end){
            int tmp = snack[start] + snack[end];
            if(tmp == M){
                weight = M;
                break;
            }
            else if(tmp < M){
                start++;
                weight = Math.max(weight, tmp);
            }
            else {
                end--;
            }
        }
    }
}
