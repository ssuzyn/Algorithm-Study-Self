import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int[] alphabet = new int[26];
            boolean wrong = false;

            for(int j = 0; j < input.length; j++){
                char tmp = input[j];
                alphabet[tmp - 'A']++;
                if(alphabet[tmp - 'A'] == 3){
                    if(j + 1 < input.length){
                        if(input[j + 1] != tmp){
                            wrong = true;
                            break;
                        }
                        else{
                            alphabet[tmp - 'A'] = 0;
                            j++;
                        }
                    }
                    else{
                        wrong = true;
                        break;
                    }
                }
            }
            if(wrong) sb.append("FAKE\n");
            else sb.append("OK\n");
        }
        System.out.print(sb);
    }
}
