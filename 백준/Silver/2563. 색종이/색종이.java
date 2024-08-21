import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		int[][] paper = new int[100][100]; // 100 x 100 도화지
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()); // 열
			int x  = Integer.parseInt(st.nextToken()); // 행
			
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					paper[j][k] = 1; // 겹치더라도 1로 초기화
				}
			}
			
		}

		int size = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1) size ++;
			}
		}
		
		System.out.println(size);
		
	}

}
