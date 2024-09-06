import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
            int K = Integer.parseInt(st.nextToken()); // K번째로 큰 수
            String input = br.readLine();

            int window = N / 4; // 각 변에는 동일한 개수의 숫자
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < window; i++) {
                int rotateIdx = i;

                for(int j = 0; j < 4; j++) { // 4번
                    int start = (rotateIdx + j * window) % N;
                    int end = (start + window) % N;

                    String hex;

                    if(start < end){
                        hex = input.substring(start, end);
                    }
                    else{
                        hex = input.substring(start) + input.substring(0, end);
                    }
                    int num = Integer.parseInt(hex, 16);
                    if(!list.contains(num)) list.add(num);
                }
            }

            Collections.sort(list, Collections.reverseOrder());
            System.out.println("#" + t + " " + list.get(K-1));
        }
    }
}
