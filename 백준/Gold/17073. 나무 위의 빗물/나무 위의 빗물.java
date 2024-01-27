import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		
		List<Integer>[] tree = new ArrayList[N + 1];
		for(int i = 1; i < N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		
		int leafCnt = 0;
		for(int i = 2; i <= N; i++) {
			if(tree[i].size() == 1) leafCnt++;
		}
		
		System.out.println(String.format("%.10f", (double)W/leafCnt));
		
		
	}
}
