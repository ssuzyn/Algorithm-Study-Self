import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
	public static int m;
	public static int[][] trashMap;
	public static int count;
	
	
	public static boolean dfs(int x, int y) {
		
		if (x <= -1 || x >=n || y <= -1 || y >= m) {
			return false;
	    }
		
	    if (trashMap[x][y] == 1) {
	    	count++;
	    	
	    	trashMap[x][y] = 0;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
	        return true;
	    }
	       
	    return false;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int trash = Integer.parseInt(st.nextToken());
		
		trashMap = new int[n][m];
 		for(int i = 0; i < trash; i++) {
			st = new StringTokenizer(br.readLine());
			trashMap[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
 		
 		List<Integer> result = new ArrayList<>();
 		for(int i = 0; i < n; i++) {
 			for(int j = 0; j < m; j++) {
 				count = 0;
 				if(dfs(i, j)) {
 					result.add(count);
 				}
 			}
 		}
 	
 		System.out.println(Collections.max(result));

	}

}
