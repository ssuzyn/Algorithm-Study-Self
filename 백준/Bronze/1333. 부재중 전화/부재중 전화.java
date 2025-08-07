import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 총 노래 갯수
		int L = Integer.parseInt(st.nextToken()); // 모든 노래 길이
		int D = Integer.parseInt(st.nextToken()); // 전화벨

		ArrayList<Boolean> album = new ArrayList<>();

		for(int n = 0; n < N; n++){
			for(int l = 0; l < L; l++) album.add(true);
			for(int t = 0; t < 5; t++) album.add(false);
		}

		int time = 0;
		while(time < album.size()){
			if(!album.get(time)) break;
			time += D;
		}

		System.out.println(time);
	}

}