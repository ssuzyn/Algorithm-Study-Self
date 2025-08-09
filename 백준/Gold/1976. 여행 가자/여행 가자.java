import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parent;

	private static int findParent(int x){
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}

	private static void union(int a, int b){
		int rootA = findParent(a);
		int rootB = findParent(b);

		if(rootA != rootB) parent[rootB] = rootA;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 여행 계획

		parent = new int[N+1];
		for(int i = 1; i <= N; i++){
			parent[i] = i;
		}

		StringTokenizer st;
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++){
				int isConnected = Integer.parseInt(st.nextToken());
				if(isConnected == 1) union(i, j);
			}
		}

		int root = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			int tmp = Integer.parseInt(st.nextToken());

			if(i == 0) root = findParent(tmp);
			if(root != findParent(tmp)){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}