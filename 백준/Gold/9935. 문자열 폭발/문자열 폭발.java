import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		StringBuilder stack = new StringBuilder();
		for(char tmp : input){
			stack.append(tmp);

			if(stack.length() >= bomb.length){
				boolean isSame = true;

				for(int j = 0; j < bomb.length; j++){
					if(stack.charAt(stack.length() - 1 - j) != bomb[bomb.length - 1 - j]){
						isSame = false;
						break;
					}
				}

				if(isSame){
					stack.delete(stack.length() - bomb.length, stack.length());
				}
			}
		}

		if(stack.length() == 0){
			System.out.println("FRULA");
		}
		else{
			System.out.println(stack);
		}
	}
}