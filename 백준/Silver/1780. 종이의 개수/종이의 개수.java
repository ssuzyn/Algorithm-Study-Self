import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int[][] paper;
	static int minus = 0, zero = 0, one = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);

	}

	private static void divide(int start, int end, int size){
		if(checkPaper(start, end, size)){
			int color = paper[start][end];
			if(color == -1) minus++;
			else if(color == 0) zero++;
			else one++;
			return;
		}

		int newSize = size/3;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				divide(start + i * newSize, end + j * newSize, newSize);
			}
		}
	}

	private static boolean checkPaper(int start, int end, int size){
		int first = paper[start][end];
		for(int i = start; i < start + size; i++){
			for(int j = end; j < end + size; j++){
				if(first != paper[i][j]) return false;
			}
		}
		return true;
	}

}