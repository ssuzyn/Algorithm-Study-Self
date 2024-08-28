import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static int[] parent;
	
	static void make() {
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findParent(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parent = new int[N + 1];
			make();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op == 0) union(a, b);
				if(op == 1) {
					if(findParent(a) == findParent(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
