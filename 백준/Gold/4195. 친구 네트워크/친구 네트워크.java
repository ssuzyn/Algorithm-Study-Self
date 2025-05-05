import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	static int[] parent;
	static int[] networkSize;

	private static void init(int n) {
		parent = new int[n];
		networkSize = new int[n];

		for(int i = 0; i < n; i++) {
			parent[i] = i;
			networkSize[i] = 1; // 초기 네트워크 크기는 1
		}
	}

	private static int find(int x){
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}

	private static int union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);

		if(rootA == rootB) return networkSize[rootA];

		// 친구 네트워크 합치기
		parent[rootB] = rootA;
		networkSize[rootA] += networkSize[rootB];
		return networkSize[rootA];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0){
			int F = Integer.parseInt(br.readLine());
			HashMap<String, Integer> personToId = new HashMap<>();
			int cnt = 0;

			init(2 * F);

			for(int i = 0; i < F; i++){
				String[] names = br.readLine().split(" ");
				for(String name : names){
					if(!personToId.containsKey(name)){
						personToId.put(name, cnt++);
					}
				}

				sb.append(union(personToId.get(names[0]), personToId.get(names[1]))).append("\n");
			}
		}

		System.out.println(sb);
	}

}
