import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length; i++){
            stack.push(line[i]);
            if(stack.size() < bomb.length) continue;

            boolean canPop = true;
            if(stack.peek() == bomb[bomb.length - 1]){
                for(int j = 2; j <= bomb.length; j++){
                    if(stack.get(stack.size() - j) != bomb[bomb.length - j]){
                        canPop = false;
                        break;
                    }
                }
                if(canPop){
                    for(int j = 0; j < bomb.length; j++) stack.pop();
                }
            }
        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) sb.append(stack.pop());
            System.out.println(sb.reverse());
        }

    }
}
