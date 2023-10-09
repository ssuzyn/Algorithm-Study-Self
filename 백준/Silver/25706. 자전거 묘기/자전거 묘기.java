import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void run(int n, int[] heights) {
		
		int [] result = new int[n];
		
		for(int i = n-1; i >= 0; i--) {
			
			int step = i + heights[i] + 1;
			
			if(step >= n) {
				result[i] = 1;
			}
			else {
				result[i] = result[step] + 1;
			}
		}
		
		for(int num: result) {
			System.out.print(num + " ");
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] heights = new int[n];
		
		for(int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		run(n, heights);

	}

}