import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N자리 숫자
        primeNumber(0, "");
    }

    private static void primeNumber(int cnt, String number){
        if(cnt == N){
            System.out.println(number);
            return;
        }

        for(int i = 1; i <= 9; i++){
            if(!isValid(number + i)) continue;
            primeNumber(cnt + 1, number + i);
        }
    }

    private static boolean isValid(String number){
        int tmp = Integer.parseInt(number);
        if(tmp < 2) return false;
        for(int i = 2; i <= Math.sqrt(tmp); i++){
            if(tmp % i == 0) return false;
        }
        return true;
    }
}
