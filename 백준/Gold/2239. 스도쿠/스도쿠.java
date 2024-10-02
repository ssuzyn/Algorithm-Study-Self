import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] map = new int[9][9];
    static boolean solved = false; // 첫 해를 찾으면 중단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        sudoku(0, 0);

        // 결과 출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void sudoku(int x, int y) {
        if (solved) return;

        if (x == 9) {
            solved = true;
            return;
        }

        if (map[x][y] > 0) {
            if (y == 8) {
                sudoku(x + 1, 0);
            } else {
                sudoku(x, y + 1);
            }
        } else {
            // 빈 칸일 경우, 숫자를 넣어본다
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    if (y == 8) {
                        sudoku(x + 1, 0);
                    } else {
                        sudoku(x, y + 1);
                    }
                    if (solved) return; // 이미 해결된 경우 중단
                    map[x][y] = 0;
                }
            }
        }
    }

    private static boolean check(int x, int y, int target) {
        // 행과 열 확인
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == target || map[i][y] == target) return false;
        }
        
        // 3x3 박스 확인
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == target) return false;
            }
        }

        return true;
    }
}
