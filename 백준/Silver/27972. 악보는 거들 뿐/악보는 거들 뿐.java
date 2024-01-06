import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> music = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			music.add(Integer.parseInt(st.nextToken()));
		}
		
		int up = 0, down = 0, result = 0;
		for(int i = 1; i < M; i++) {
			if(music.get(i) > music.get(i-1)) {
				down = 0;
				up++;
				result = Math.max(result, up);
			}
			else if(music.get(i) < music.get(i-1)) {
				down++;
				up = 0;
				result = Math.max(result, down);
			}
		}
		
		System.out.println(result+1);
	}

}
