import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int value = 1;
		
		for(int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			
			if(tmp == '(') {
				stack.push(tmp);
				value *= 2;
				continue;
			}
			
			if(tmp == '[') {
				stack.push(tmp);
				value *= 3;
				continue;
			}
			
			if(tmp == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					answer = 0;
					break;
				}
				
				if(input.charAt(i-1) == '(') {
					answer += value;
				}
				stack.pop();
				value /= 2;
				continue;
			}
			
			if(tmp == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					answer = 0;
					break;
				}
				
				if(input.charAt(i-1) == '[') {
					answer += value;
				}
				stack.pop();
				value /= 3;
			
			}
		}
		
		if(!stack.isEmpty()) System.out.println(0);
		else System.out.println(answer);
	}

}
