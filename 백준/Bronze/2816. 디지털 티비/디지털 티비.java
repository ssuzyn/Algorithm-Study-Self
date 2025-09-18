import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<String> channel = new LinkedList<>();

		for(int i = 0; i < N; i++){
			channel.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		String[] kbs = {"KBS1", "KBS2"};
		int idx = 0;
		for(String cur : kbs){
			while(true){
				if(idx == 0 && channel.get(idx + 1).equals(cur)){
					sb.append(3);
					channel.remove(idx + 1);
					break;
				}

				if(channel.get(idx).equals(cur)){
					for(int i = 0; i < idx; i++){
						sb.append(4);
					}
					if(!cur.equals("KBS2")) {
						sb.append(1);
						channel.remove(idx);
						idx = 0;
					}
					break;
				}
				else{
					sb.append(1);
					idx++;
				}
			}
		}

		System.out.print(sb);

	}

}