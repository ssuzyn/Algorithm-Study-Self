import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void checkFox(String text, List<String> cry) {
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(text);
		
		while(st.hasMoreTokens()) {
			String isFox = st.nextToken();
			if(!cry.contains(isFox)) {
				sb.append(isFox).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		String text = "";
		List<String> cry = new ArrayList<>();
		
		while(count-- > 0) {
			text = br.readLine();
			
			while(true) {
				String line = br.readLine();
				if(line.equals("what does the fox say?")) break;
				
				st = new StringTokenizer(line);
				st.nextToken();
				st.nextToken();
				cry.add(st.nextToken());
			}
			
			checkFox(text, cry);
		}

	}

}
