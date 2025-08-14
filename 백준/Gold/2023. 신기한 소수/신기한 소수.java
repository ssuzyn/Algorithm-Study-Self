import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		getPrimeNumber(0, 0);
	}

	private static void getPrimeNumber(int cnt, int num){
		if(cnt == N){
			System.out.println(num);
			return;
		}

		for(int i = 1; i <= 9; i++){
			int tmp = num * 10 + i;
			if(isValid(tmp)) getPrimeNumber(cnt + 1, tmp);
		}
	}

	private static boolean isValid(int num){
		if(num < 2) return false;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0) return false;
		}

		return true;
	}
}