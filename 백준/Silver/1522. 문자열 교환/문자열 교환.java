import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int window = 0;
		int size = str.length;

		for(int i = 0; i < size; i++){
			if(str[i] == 'a') window++;
		}

		if(window == 0 || window == size) {
			System.out.println(0);
			return;
		}

		int minB = Integer.MAX_VALUE;
		for(int start = 0; start < size; start++){
			int countB = 0;

			for(int i = 0; i < window; i++){
				int idx = (start + i) % size;
				if(str[idx] == 'b') countB++;
			}

			if(countB == 0){
				minB = 0;
				break;
			}

			minB = Math.min(minB, countB);
		}

		System.out.println(minB);
	}

}