import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] village;
	
	static void initVillage() {
		for(int i = 1; i <= N; i++) {
			village[i] = i;
		}
	}
	
	static int findVillage(int x) {
		if(x == village[x]) return x;
		else return village[x] = findVillage(village[x]);
	}
	
	static void union(int a, int b) {
		a = findVillage(a);
		b = findVillage(b);
		
		if(a < b) village[b] = a;
		else village[a] = b;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			village = new int[N + 1];
			initVillage();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			int answer = 0;
			for(int i = 1; i <= N; i++) {
				if(i == village[i]) answer++;
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
		
	}

}
