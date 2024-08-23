import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int H, W;
	static char[][] map;
	static int[] tank = new int[3]; // [0]: 행 위치, [1]: 열 위치, [2]: 방향 인덱스 (0: '^', 1: 'v', 2: '<', 3: '>')
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
	static char[] direction = {'^', 'v', '<', '>'}; // 방향에 따른 전차 모양

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine()); // 테스트 케이스

	    for (int t = 1; t <= T; t++) {
	        String[] input = br.readLine().split(" ");
	        H = Integer.parseInt(input[0]); // 높이
	        W = Integer.parseInt(input[1]); // 너비
	        map = new char[H][W];

	        for (int i = 0; i < H; i++) {
	            String line = br.readLine();
	            map[i] = line.toCharArray();

	            for (int j = 0; j < W; j++) {
	                char c = map[i][j];
	                if (c == '^' || c == 'v' || c == '<' || c == '>') {
                        tank[0] = i; // 행 위치
                        tank[1] = j; // 열 위치
                         
                        // 방향 인덱스를 저장
                        if (c == '^') tank[2] = 0;
                        if (c == 'v') tank[2] = 1;
                        if (c == '<') tank[2] = 2;
                        if (c == '>') tank[2] = 3;
                    }
	            }
	        }

	        int size = Integer.parseInt(br.readLine());
	        char[] user = br.readLine().toCharArray();

	        for (char cmd : user) {
	            game(cmd);
	        }

	        System.out.print("#" + t + " ");
	        print();
	    }
	}

	private static void print() {
	    for (int i = 0; i < H; i++) {
	        for (int j = 0; j < W; j++) {
	            System.out.print(map[i][j]);
	        }
	        System.out.println();
	    }
	}

	private static boolean isValid(int x, int y) {
	    return x >= 0 && x < H && y >= 0 && y < W;
	}

	private static void moveTank(int dir) {
	    tank[2] = dir; // 전차 방향 변경
	    map[tank[0]][tank[1]] = direction[dir];

	    int nx = tank[0] + d[dir][0];
	    int ny = tank[1] + d[dir][1];

	    if (isValid(nx, ny) && map[nx][ny] == '.') { // 다음 이동할 위치가 평지인 경우
	        map[nx][ny] = map[tank[0]][tank[1]]; // 다음 전차가 이동하는 위치
	        map[tank[0]][tank[1]] = '.'; // 현재 전차가 있는 위치 -> 평지
	        tank[0] = nx; // 전차 위치 변경
	        tank[1] = ny;
	    }
	}

	private static void fire() {
	    int x = tank[0], y = tank[1];
	    int dir = tank[2];

	    while (true) {
	        x += d[dir][0];
	        y += d[dir][1];

	        if (!isValid(x, y)) break; // 맵 밖으로 나가면 중지
	        if (map[x][y] == '#') break; // 강철벽을 만나면 중지
	        if (map[x][y] == '*') { // 벽돌벽을 만나면 파괴 후 중지
	            map[x][y] = '.';
	            break;
	        }
	    }
	}

	private static void game(char cmd) {
	    switch (cmd) {
	        case 'U':
	            moveTank(0);
	            break;
	        case 'D':
	            moveTank(1);
	            break;
	        case 'L':
	            moveTank(2);
	            break;
	        case 'R':
	            moveTank(3);
	            break;
	        case 'S':
	            fire();
	            break;
	    }
	}
}
