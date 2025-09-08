import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] game = new char[3][3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			String input = br.readLine();
			if(input.equals("end")) break;

			int X = 0;
			int O = 0;

			for(int i = 0; i < 9; i++){
				game[i / 3][i % 3] = input.charAt(i);
				if(game[i / 3][i % 3] == 'X') X++;
				else if(game[i / 3][i % 3] == 'O') O++;
			}

			if(X == O + 1){
				if(X + O == 9 && !bingo('O')) sb.append("valid").append("\n");
				else if(!bingo('O') && bingo('X')) sb.append("valid").append("\n");
				else sb.append("invalid").append("\n");
			}
			else if(X == O){
				if(!bingo('X') && bingo('O')) sb.append("valid").append("\n");
				else sb.append("invalid").append("\n");
			}
			else sb.append("invalid").append("\n");
		}

		System.out.println(sb);
	}

	private static boolean bingo(char type){

		for(int i = 0; i < 3; i++){
			if(game[i][0] == type && game[i][1] == type && game[i][2] == type){
				return true;
			}

			if(game[0][i] == type && game[1][i] == type && game[2][i] == type){
				return true;
			}
		}

		if(game[0][0] == type && game[1][1] == type && game[2][2] == type) {
			return true;
		}

		if(game[0][2] == type && game[1][1] == type && game[2][0] == type){
			return true;
		}

		return false;

	}

}