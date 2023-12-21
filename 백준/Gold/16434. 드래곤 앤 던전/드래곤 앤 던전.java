import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int room = Integer.parseInt(st.nextToken());
		long heroAttack = Long.parseLong(st.nextToken());
		long curHp = 0, maxHp = 0;
		
		for(int i = 0; i < room; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(t == 1) {
				curHp += a * ((h / heroAttack) - (h % heroAttack != 0? 0 : 1));
				maxHp = Math.max(maxHp, curHp);
			}
			else {
				heroAttack += a;
				curHp = Math.max(curHp - h, 0);
			}
		}
		
		maxHp++;
		
		System.out.println(maxHp);
	}

}