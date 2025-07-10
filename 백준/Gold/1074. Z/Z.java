import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, r, c;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		solution(0, 0, (1 << N));

	}

	private static void solution(int x, int y, int size){
		if(size == 1){
			System.out.println(answer);
			return;
		}

		int newSize = size / 2;

		if(r < x + newSize && c < y + newSize){ // 1사분면
			solution(x, y, newSize);
		}
		else if(r < x + newSize && c >= y + newSize){ // 2사분면
			answer += newSize * newSize;
			solution(x, y + newSize, newSize);
		}
		else if(r >= x + newSize && c < y + newSize){ // 3사분면
			answer += newSize * newSize * 2;
			solution(x + newSize, y, newSize);
		}
		else{ // 4사분면
			answer += newSize * newSize * 3;
			solution(x + newSize, y + newSize, newSize);
		}
	}

}