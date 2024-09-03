import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        String vowels = "aeiou";
        
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        
        while(idx < input.length) {
        	if(vowels.contains(String.valueOf(input[idx]))) {
        		answer.append(input[idx]);
        		idx += 3;
        	}
        	else {
        		answer.append(input[idx]);
        		idx += 1;
        	}
        }
        System.out.println(answer.toString());
    }
}
