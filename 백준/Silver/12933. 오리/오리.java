import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[6];
        int size = str.length();
        int max = 0;
        arr[0] = size;

        for(int i = 0; i < size; i++) {
            int n = 0;
            if(str.charAt(i) == 'q') n = 1;
            if(str.charAt(i) == 'u') n = 2;
            if(str.charAt(i) == 'a') n = 3;
            if(str.charAt(i) == 'c') n = 4;
            if(str.charAt(i) == 'k') n = 5;
            if(arr[n-1] == 0) {
                System.out.println("-1");
                return;
            }
            arr[n]++;
            arr[n-1]--;
            max = Math.max(max, arr[1]+arr[2]+arr[3]+arr[4]);
        }

        if(arr[5] * 5 != size) {
            System.out.println("-1");
            return;
        }
        System.out.println(max);
    }
}
