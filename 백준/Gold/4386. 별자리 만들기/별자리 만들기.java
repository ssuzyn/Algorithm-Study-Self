import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static double[][] star;
	static int[] parent;

	static class Zodiac{
		int star1;
		int star2;
		double cost;

		Zodiac(int star1, int star2, double cost){
			this.star1 = star1;
			this.star2 = star2;
			this.cost = cost;
		}
	}

	private static void initParent(){
		parent = new int[N];
		for(int i = 0; i < N; i++){
			parent[i] = i;
		}
	}

	private static int findParent(int x){
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}

	private static boolean union(int a, int b){
		int rootA = findParent(a);
		int rootB = findParent(b);

		if(rootA != rootB){
			parent[rootB] = rootA;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new double[N][2];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}

		PriorityQueue<Zodiac> pq = new PriorityQueue<>((a, b) -> Double.compare(a.cost, b.cost));
		for(int i = 0; i < N-1; i++){
			for(int j = i + 1; j < N; j++){
				double dist = Math.sqrt(Math.pow(star[i][0] - star[j][0], 2) + Math.pow(star[i][1] - star[j][1], 2));
				pq.add(new Zodiac(i, j, dist));
			}
		}

		initParent();

		int count = 0;
		double answer = 0;
		while(!pq.isEmpty()){
			Zodiac zodiac = pq.poll();

			if(union(zodiac.star1, zodiac.star2)){
				answer += zodiac.cost;
				count++;
			}

			if(count == N-1) break;
		}

		System.out.printf("%.2f\n", answer);
	}

}