import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bulb = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            bulb[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> patternLengths = new ArrayList<>();
        int cnt = 1;

        for(int i = 1; i < N; i++){
            if(bulb[i] != bulb[i-1]) cnt++;
            else{
                patternLengths.add(cnt);
                cnt = 1;
            }
        }
        patternLengths.add(cnt); // 마지막 패턴 추가

        int answer = 0;
        int size = patternLengths.size();

        if(size == 1) answer = patternLengths.get(0);
        else if(size == 2) answer = patternLengths.get(0) + patternLengths.get(1);
        else{
            for(int i = 0; i < size - 2; i++){
                answer = Math.max(answer,
                    patternLengths.get(i) + patternLengths.get(i+1) + patternLengths.get(i+2));
            }
        }

        System.out.println(answer);
    }
}