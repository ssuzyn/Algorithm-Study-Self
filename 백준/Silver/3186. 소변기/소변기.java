import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int useTime = Integer.parseInt(st.nextToken());
		int endTime = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int size = N + endTime + 1;
		int data[] = new int[size];


		String input = br.readLine();
		for(int i = 0; i < N; i++){
			data[i] = input.charAt(i) - '0';
		}

		int zero = 0;
		int one = 0;
		int index = 0;
		boolean used = false;
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < size; i++){
			if(used){ // 사용중인 경우
				if(data[i] == 0){
					zero++;
					index = i;

					if(zero == endTime){
						sb.append(index + 1).append("\n");
						zero = 0;
						one = 0;
						used = false;
					}
				}
				else zero = 0;
			}
			else{ // 사용하지 않는 경우
				if(data[i] == 1){
					one++;

					if(one == useTime){
						used = true;
						one = 0;
					}
				}
				else one = 0;
			}
		}

		if(sb.length() == 0) sb.append("NIKAD");
		System.out.println(sb);
	}
}
