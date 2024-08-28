import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = -1;
    static ArrayList<Integer>[] family;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        family = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++) {
        	family[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family[a].add(b);
            family[b].add(a);
        }
        
        dfs(p1, p2, 0);
        System.out.println(answer);
        
    }
    
    static void dfs(int cur, int end, int depth) {
    	if(cur == end) {
    		answer = depth;
    		return;
    	}
    	
    	visited[cur] = true;
    	for(int i = 0; i < family[cur].size(); i++) {
    		int tmp = family[cur].get(i);
    		if(!visited[tmp]) {
        		dfs(tmp, end, depth + 1);
    		}
    	}
    }
}
