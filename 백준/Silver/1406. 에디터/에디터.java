import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		List<Character> words = new LinkedList<>();
		for(int i = 0; i < input.length; i++){
			words.add(input[i]);
		}

		int cursor = input.length;
		int N = Integer.parseInt(br.readLine());

		//iterator 메소드 호출
		ListIterator<Character> iter = words.listIterator();
		//처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨뒤로 이동시켜줌 (ex. abc|)
		while(iter.hasNext()) {
			iter.next();
		}

		while(N-- > 0){
			String command = br.readLine();
			char c = command.charAt(0);

			switch(c){
				case 'L':
					if(iter.hasPrevious()) iter.previous();
					break;
				case 'D':
					if(iter.hasNext()) iter.next();
					break;
				case 'B':
					if(iter.hasPrevious()){
						iter.previous();
						iter.remove();
					}
					break;
				case 'P':
					char tmp = command.charAt(2);
					iter.add(tmp);
					break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(char w : words){
			sb.append(w);
		}
		System.out.println(sb);
	}
}
