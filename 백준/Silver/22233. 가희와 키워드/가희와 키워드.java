import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> memo = new HashSet<>();

		for(int i = 0; i < N; i++){
			memo.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){
			String[] input = br.readLine().split(",");
			for(String word : input){
				memo.remove(word);
			}

			sb.append(memo.size()).append("\n");
		}

		System.out.print(sb);
	}
}