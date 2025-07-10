import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, white = 0, blue = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N + 1][N + 1];

		for(int i = 1; i <= N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dividePaper(1, 1, N);

		System.out.println(white);
		System.out.println(blue);

	}

	private static void dividePaper(int start, int end, int size){
		if(checkPaper(start, end, size)){
			if(paper[start][end] == 0) white++;
			else blue++;
			return;
		}

		int half = size/2;
		dividePaper(start, end, half);
		dividePaper(start + half, end, half);
		dividePaper(start, end + half, half);
		dividePaper(start + half, end + half, half);

	}

	private static boolean checkPaper(int start, int end, int size){
		int color = paper[start][end];
		for(int i = start; i < start + size; i++){
			for(int j = end; j < end + size; j++){
				if(color != paper[i][j]) return false;
			}
		}
		return true;
	}
}