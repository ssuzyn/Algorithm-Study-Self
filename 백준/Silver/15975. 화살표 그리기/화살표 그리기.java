import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int length = 0;
		List<ArrayList<Integer>> color = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			color.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken()) - 1;
			color.get(index).add(position);
		}
		
		for(ArrayList<Integer> row: color) {
			Collections.sort(row);
			
			if(row.size() < 2) continue;
			
			for(int i = 0; i < row.size(); i++) {
				if(i == 0)
					length += row.get(i+1) - row.get(i);
				else if(i == row.size() - 1)
					length += row.get(i) - row.get(i-1);
				else
					length += Math.min(row.get(i+1) - row.get(i), row.get(i) - row.get(i-1));
			}
			
		}
		
		System.out.println(length);
		
	}

}
