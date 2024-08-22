import java.util.Scanner;

public class Main {
	
	static int[][] paper = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 수
		
		for(int n = 0; n < N; n++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					paper[x + i][y + j] = 1;
				}
			}
		}
		
		int cnt = 0;
		int[][] direction = {{1, 0}, {0, 1}}; // 아래, 오른쪽 방향
		
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				
				for(int d = 0; d < 2; d++) {
					int nx = i + direction[d][0];
					int ny = j + direction[d][1];
					
					if(nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && paper[nx][ny] != paper[i][j]) {
						cnt++;
					}
				}
				
			}
		}
		
		System.out.println(cnt);

	}

}
