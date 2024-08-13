import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    static int numbers[] = new int[6];
    static boolean babygin = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            String str = br.readLine();
            for(int i = 0; i < 6; i++) {
                numbers[i] = str.charAt(i) - '0';
            }

            permutation(0);
            System.out.println("#" + t + " " + babygin);
            babygin = false;

        }
    }

    public static void permutation(int idx) {
        if(babygin) {
            return;
        }

        if(idx == numbers.length) {
            int[] front = Arrays.copyOfRange(numbers, 0, 3);
            int[] back = Arrays.copyOfRange(numbers, 3, 6);
            babygin = checkBabyGin(front) && checkBabyGin(back);
            return;
        }

        for(int i = idx; i < numbers.length; i++) {
            swap(idx, i);
            permutation(idx + 1);
            swap(idx, i);
        }
    }

    private static void swap(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static boolean checkBabyGin(int[] arr) {
        Arrays.sort(arr);

        if(arr[1] == arr[0] + 1 && arr[2] == arr[1] + 1) // check run
            return true;

        if(arr[0] == arr[1] && arr[1] == arr[2]) // check triplet
            return true;

        return false;
    }

}

