import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전자기기의 개수
        int M = Integer.parseInt(st.nextToken()); // 콘센트의 개수
        Integer[] charge = new Integer[N]; // 충전에 필요한 시간

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            charge[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(charge, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < M; i++){
            pq.add(0);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            int time = pq.poll();
            pq.add(charge[i] + time);
            max = Math.max(max, charge[i] + time);
        }

        System.out.println(max);
        
    }
}