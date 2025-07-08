import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sub = br.readLine().split("-");
		int sum = Integer.MAX_VALUE;

		for(int i = 0; i < sub.length; i++){
			int tmp = 0;

			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리해 해당 토큰들을 더한다.
			String[] add = sub[i].split("\\+");

			// 덧셈으로 나뉜 토큰들을 모두 더한다.
			for(int j = 0; j < add.length; j++){
				tmp += Integer.parseInt(add[j]);
			}

			if(sum == Integer.MAX_VALUE) sum = tmp;
			else sum -= tmp;
		}

		System.out.println(sum);
	}
}