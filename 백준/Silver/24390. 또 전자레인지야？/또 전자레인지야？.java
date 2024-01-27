import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cooking = br.readLine().split(":");
		int M = Integer.parseInt(cooking[0]);
		int S = Integer.parseInt(cooking[1]);
		
		int click = 1;
		
		click += M / 10;
		click += M % 10;
		
		if(S >= 30) {
			click += (S - 30) / 10;
		}
		else if(S < 30){
			click += S / 10;
		}
		
		System.out.println(click);
		
	}

}
