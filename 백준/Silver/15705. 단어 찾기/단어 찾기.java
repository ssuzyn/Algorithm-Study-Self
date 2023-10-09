import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static char[][] map;
	public static int N, M;
	public static String word;
	
	public static boolean findHorizontal() { //가로 탐색
		int size = word.length();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				StringBuilder sb = new StringBuilder();
				
				while(x < M && y < N) {
					if(sb.length() == size) break;
					sb.append(map[x][y]);
					x++;
				}
				
				if(sb.toString().equals(word)||sb.reverse().toString().equals(word)) {
					return true;
				}
			}
			
		}
		
		return false;
		
	}
	
	public static boolean findVertical() { //세로 탐색
		int size = word.length();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				StringBuilder sb = new StringBuilder();
				
				while(x < M && y < N) {
					if(sb.length() == size) break;
					sb.append(map[x][y]);
					y++;
				}
				
				if(sb.toString().equals(word)||sb.reverse().toString().equals(word)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static boolean findUpDiagonal() { //상향 대각선
		int size = word.length();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				StringBuilder sb = new StringBuilder();
				
				while(x < M && y > 0) {
					if(sb.length() == size) break;
					sb.append(map[x][y]);
					x++;
					y--;
				}
				
				if(sb.toString().equals(word)||sb.reverse().toString().equals(word)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static boolean findDownDiagonal() { //하향 대각선
		int size = word.length();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				StringBuilder sb = new StringBuilder();
				
				while(x < M && y < N) {
					if(sb.length() == size) break;
					sb.append(map[x][y]);
					x++;
					y++;
				}
				
				if(sb.toString().equals(word)||sb.reverse().toString().equals(word)) {
					return true;
				}
			}
			
		}

		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		word = br.readLine();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		if(findHorizontal()) {
			System.out.println("1");
		}
		else if(findVertical()) {
			System.out.println("1");
		}
		else if(findDownDiagonal()) {
			System.out.println("1");
		}
		else if(findUpDiagonal()) {
			System.out.println("1");
		}
		else System.out.println("0");
			
	}
}
