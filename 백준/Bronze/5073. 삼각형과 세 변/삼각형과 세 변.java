import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0) {
				System.out.print(sb);
				return;
			}

			if(!isTriangle(a, b, c)) {
				sb.append("Invalid").append("\n");
				continue;
			}

			if(a == b && a == c) sb.append("Equilateral").append("\n");
			else if(a != b && a != c && b != c) sb.append("Scalene").append("\n");
			else sb.append("Isosceles").append("\n");
		}
	}

	private static boolean isTriangle(int a, int b, int c){
		if(a + b <= c) return false;
		else if(a + c <= b) return false;
		else if(c + b <= a) return false;
		return true;
	}
}