import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			String[] nums = new String[N];
			for(int i = 0; i < N; i++){
				nums[i] = br.readLine();
			}
			Arrays.sort(nums);

			boolean flag = true;
			for(int i = 0; i < N-1; i++){
				if(nums[i+1].startsWith(nums[i])){
					sb.append("NO\n");
					flag = false;
					break;
				}
			}
			if(flag) sb.append("YES\n");
		}
		System.out.println(sb);
	}
}
