import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int H, W;
	static char[][] map;
	static int[] tank = new int[3]; // [0]: 행 위치, [1]: 열 위치, [2]: 방향 인덱스 (0: '^', 1: 'v', 2: '<', 3: '>')
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

	public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int T = Integer.parseInt(br.readLine()); // 테스트 케이스
	       
	       for(int t = 1; t <= T; t++) {
	    	   String[] input = br.readLine().split(" ");
	    	   H = Integer.parseInt(input[0]); // 높이
	    	   W = Integer.parseInt(input[1]); // 너비
	    	   map = new char[H][W];
	    	   
	    	   for(int i = 0; i < H; i++) {
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
	    	   
	    	   for(char cmd : user) {
	    		   game(cmd);
	    	   }
	    	   
	    	   System.out.print("#" + t + " ");
	    	   print();
	       }
	       
	       
	}
	
	private static void print() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	private static boolean isValid(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
	
	private static void game(char cmd) {
		int nx, ny;
		switch(cmd) {
		case 'U': // 상 이동
			tank[2] = 0; // 전차 방향 변경
			map[tank[0]][tank[1]] = '^';
			
			nx = tank[0] + d[0][0];
			ny = tank[1] + d[0][1];
			
			if(isValid(nx, ny)) {
				if(map[nx][ny] == '.') { // 다음 이동할 위치가 평지인 경우
					map[nx][ny] = map[tank[0]][tank[1]]; // 다음 전차가 이동하는 위치
					map[tank[0]][tank[1]] = '.'; // 현재 전차가 있는 위치 -> 평지
					tank[0] = nx; // 전차 위치 변경
					tank[1] = ny;
				}
			}
			
			break;
		case 'D': // 하 이동
			tank[2] = 1; // 전차 방향 변경
			map[tank[0]][tank[1]] = 'v';
			
			nx = tank[0] + d[1][0];
			ny = tank[1] + d[1][1];
			
			if(isValid(nx, ny)) {
				if(map[nx][ny] == '.') { // 다음 이동할 위치가 평지인 경우
					map[nx][ny] = map[tank[0]][tank[1]]; // 다음 전차가 이동하는 위치
					map[tank[0]][tank[1]] = '.'; // 현재 전차가 있는 위치 -> 평지
					tank[0] = nx; // 전차 위치 변경
					tank[1] = ny;
				}
			}
			break;
		case 'L': // 좌 이동
			tank[2] = 2; // 전차 방향 변경
			map[tank[0]][tank[1]] = '<';
			
			nx = tank[0] + d[2][0];
			ny = tank[1] + d[2][1];
			
			if(isValid(nx, ny)) {
				if(map[nx][ny] == '.') { // 다음 이동할 위치가 평지인 경우
					map[nx][ny] = map[tank[0]][tank[1]]; // 다음 전차가 이동하는 위치
					map[tank[0]][tank[1]] = '.'; // 현재 전차가 있는 위치 -> 평지
					tank[0] = nx; // 전차 위치 변경
					tank[1] = ny;
				}
			}
			break;
		case 'R': // 우 이동
			tank[2] = 3; // 전차 방향 변경
			map[tank[0]][tank[1]] = '>';
			
			nx = tank[0] + d[3][0];
			ny = tank[1] + d[3][1];
			
			if(isValid(nx, ny)) {
				if(map[nx][ny] == '.') { // 다음 이동할 위치가 평지인 경우
					map[nx][ny] = map[tank[0]][tank[1]]; // 다음 전차가 이동하는 위치
					map[tank[0]][tank[1]] = '.'; // 현재 전차가 있는 위치 -> 평지
					tank[0] = nx; // 전차 위치 변경
					tank[1] = ny;
				}
			}
			break;
			
		case 'S': // 포탄 발사
		    if (tank[2] == 0) { // 상 방향
		        int index = tank[0] - 1;
		        while (isValid(index, tank[1])) {
		            if (map[index][tank[1]] == '#') break; // 강철벽은 파괴되지 않음
		            if (map[index][tank[1]] == '*') { // 벽돌벽 파괴
		                map[index][tank[1]] = '.';
		                break; // 벽돌을 파괴한 후 종료
		            }
		            index--;
		        }
		    } else if (tank[2] == 1) { // 하 방향
		        int index = tank[0] + 1;
		        while (isValid(index, tank[1])) {
		            if (map[index][tank[1]] == '#') break;
		            if (map[index][tank[1]] == '*') {
		                map[index][tank[1]] = '.';
		                break;
		            }
		            index++;
		        }
		    } else if (tank[2] == 2) { // 좌 방향
		        int index = tank[1] - 1;
		        while (isValid(tank[0], index)) {
		            if (map[tank[0]][index] == '#') break;
		            if (map[tank[0]][index] == '*') {
		                map[tank[0]][index] = '.';
		                break;
		            }
		            index--;
		        }
		    } else { // 우 방향
		        int index = tank[1] + 1;
		        while (isValid(tank[0], index)) {
		            if (map[tank[0]][index] == '#') break;
		            if (map[tank[0]][index] == '*') {
		                map[tank[0]][index] = '.';
		                break;
		            }
		            index++;
		        }
		    }
		    break;

		}
	}

}
