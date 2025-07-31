import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		Map<String, Integer> map = new HashMap<>();
		map.put("0000", 1);

		int t=0, g=0, p=0, f=0;
		long ans = 0;

		for(int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if(c == 'T') t++;
			else if(c == 'G') g++;
			else if(c == 'P') p++;
			else if(c == 'F') f++;

			String state = (t%3) + "" + (g%3) + "" + (p%3) + "" + (f%3);

			ans += map.getOrDefault(state, 0);
			map.put(state, map.getOrDefault(state, 0) + 1);
		}

		System.out.println(ans);
	}
}