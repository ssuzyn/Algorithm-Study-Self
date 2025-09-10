import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> card = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int tmp = Integer.parseInt(st.nextToken());
			card.put(tmp, card.getOrDefault(tmp, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){
			int key = Integer.parseInt(st.nextToken());
			sb.append(card.get(key) == null ? 0 : card.get(key)).append(" ");
		}

		System.out.print(sb);
	}

}