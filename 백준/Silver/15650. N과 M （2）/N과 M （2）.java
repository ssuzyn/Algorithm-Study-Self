import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, M;
	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		visited = new boolean[N + 1];

		permutation(0, 1);

	}

	private static void permutation(int cnt, int start){
		if(cnt == M){
			for(int num : numbers){
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i <= N; i++){
			numbers[cnt] = i;
			permutation(cnt + 1, i + 1);
		}
	}
}