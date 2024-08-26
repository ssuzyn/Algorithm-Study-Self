import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        while(A != B){
            if(A > B) {
                System.out.println(-1);
                return;
            }

            if(B % 2 == 0){
                B /= 2;
            }
            else if(B % 10 == 1){
                B /= 10;
            }
            else{
                System.out.println(-1);
                return;
            }
            count++;
        }

        System.out.println(count);
    }
}
