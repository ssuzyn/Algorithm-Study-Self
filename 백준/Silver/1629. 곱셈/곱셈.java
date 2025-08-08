import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B, C));
	}

	private static long pow(long A, long B, long C){
		if(B == 0) return 1;

		if(B % 2 == 0){
			long half = pow(A, B/2, C);
			return (half * half) % C;
		}
		else{
			return (A * pow(A, B-1, C)) % C;
		}
	}

}