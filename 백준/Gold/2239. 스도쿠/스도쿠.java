import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int[][] sudoku;
	static boolean[][][] check;
	static List<int[]> zero;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		check = new boolean[3][9][10];
		zero = new ArrayList<>();
		flag = false;

		for(int i = 0; i < 9; i++){
			String line = br.readLine();
			for(int j = 0; j < 9; j++){
				int num = line.charAt(j) - '0';
				sudoku[i][j] = num;
				if(num == 0) zero.add(new int[]{i, j});
				else{
					check[0][i][num] = true; // i번째 행에 num이 있다.
					check[1][j][num] = true; // j번째 행에 num이 있다.
					check[2][getSection(i, j)][num] = true; // 해당 박스구역에 num이 있다.
				}
			}
		}

		solve(0);

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	private static int getSection(int r, int c){
		int row = r/3;
		int col = c/3;
		return row * 3 + col;
	}

	private static boolean isValid(int r, int c, int num){
		return !(check[0][r][num] || check[1][c][num] || check[2][getSection(r, c)][num]);
	}

	static boolean solve(int index){
		if(index == zero.size()) return true;

		int[] cur = zero.get(index);
		for(int num = 1; num <= 9; num++){
			int r = cur[0];
			int c = cur[1];
			if(isValid(r, c, num)){
				sudoku[r][c] = num;
				check[0][r][num] = true;
				check[1][c][num] = true;
				check[2][getSection(r, c)][num] = true;

				if(solve(index + 1)) return true;

				// 백트래킹
				sudoku[r][c] = 0;
				check[0][r][num] = false;
				check[1][c][num] = false;
				check[2][getSection(r, c)][num] = false;

			}
		}

		return false;
	}
}