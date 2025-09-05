import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] person = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			person[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> line = new ArrayList<>();
		for(int i = N; i > 0; i--){
			line.add(person[i], i);
		}

		for(int num : line){
			System.out.print(num + " ");
		}
	}

}