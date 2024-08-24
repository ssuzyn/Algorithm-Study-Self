import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int S, P, answer = 0;
    static String pw;
    static int[] DNA = new int[4]; // A, C, G, T
    static int[] curCount = new int[4]; // 현재 윈도우 내의 DNA 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
        pw = br.readLine(); // 임의로 만든 DNA 문자열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            DNA[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < P; i++) {
            int idx = mapCharToIndex(pw.charAt(i));
            curCount[idx]++;
        }

        if(isValid()) answer++;

        for(int i = P; i < S; i++) {
            int left = mapCharToIndex(pw.charAt(i - P));
            curCount[left]--;

            int right = mapCharToIndex(pw.charAt(i));
            curCount[right]++;

            if(isValid()) answer++;
        }


        System.out.println(answer);

    }


    private static int mapCharToIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean isValid(){
        for(int i = 0; i < 4; i++) {
            if(curCount[i] < DNA[i]) return false; // 하나라도 최소 조건을 만족하지 않으면
        }
        return true;
    }
}
