import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int[] alphabet = new int[26];
            boolean wrong = false;

            for(int j = 0; j < input.length; j++){
                int idx = input[j] - 'A';
                alphabet[idx]++;
                if(alphabet[idx] == 3){
                    if(j == input.length - 1 || input[j + 1] != input[j]){
                        wrong = true;
                        break;
                    }
                    alphabet[idx] = 0;
                    j++;
                }
            }
            if(wrong) sb.append("FAKE\n");
            else sb.append("OK\n");
        }
        System.out.print(sb);
    }
}
