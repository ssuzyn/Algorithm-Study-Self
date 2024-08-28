import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int answer;
	static int[] check;
	static ArrayList<Integer>[] friends;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        
        friends = new ArrayList[N];
        for(int i = 0; i < N; i++) {
        	friends[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	friends[a].add(b);
        	friends[b].add(a);
        }
        
        answer = 0;
        for(int i = 0; i < N; i++) {
        	check = new int[N];
        	check[i] = 1;
            dfs(i, 1);
            
            if(answer == 1) break;
        }
        
        System.out.println(answer);
	}
	
	static void dfs(int x, int depth) {
		
		if(check[x] == 5) {
			answer = 1;
			return;
		}
		
		for(int i = 0; i < friends[x].size(); i++) {
			int next = friends[x].get(i);
			if(check[next] == 0) {
				check[next] = check[x] + 1;
				dfs(next, depth + 1);
				check[next] = 0;
			}
		}
	}

}
