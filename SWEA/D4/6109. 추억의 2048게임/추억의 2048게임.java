import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static String direction;
	static int[][] map, answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			direction = st.nextToken();
			map = new int[N][N];
			answer = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(direction);
			sb.append("#" + t + "\n");
			print();
		}
		
		System.out.println(sb.toString());
	}
	
	private static void move(String direction) {
		switch(direction) {
		case "up": goUp(); break;
		case "down": goDown(); break;
		case "left": goLeft(); break;
		case "right": goRight(); break;
		}
	}
	
	private static void print() {
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				sb.append(answer[x][y]).append(" ");
			}
			sb.append("\n");
		}
		
	}
	
	private static void goUp() {
	    for (int y = 0; y < N; y++) {
	        int idx = 0;
	        int lastMerged = -1; // 마지막으로 병합된 위치

	        for (int x = 0; x < N; x++) {
	            if (map[x][y] != 0) {
	                if (idx > 0 && answer[idx - 1][y] == map[x][y] && lastMerged != idx - 1) {
	                    answer[idx - 1][y] *= 2;
	                    lastMerged = idx - 1;
	                } else {
	                    answer[idx][y] = map[x][y];
	                    idx++;
	                }
	            }
	        }
	    }
	}

	
	private static void goDown() {
	    for (int y = 0; y < N; y++) {
	        int idx = N - 1;
	        int lastMerged = -1; // 마지막으로 병합된 위치

	        for (int x = N - 1; x >= 0; x--) {
	            if (map[x][y] != 0) {
	                if (idx < N - 1 && answer[idx + 1][y] == map[x][y] && lastMerged != idx + 1) {
	                    answer[idx + 1][y] *= 2;
	                    lastMerged = idx + 1;
	                } else {
	                    answer[idx][y] = map[x][y];
	                    idx--;
	                }
	            }
	        }
	    }
	}

	
	private static void goLeft() {
	    for (int x = 0; x < N; x++) {
	        int idx = 0;
	        int lastMerged = -1; // 마지막으로 병합된 위치

	        for (int y = 0; y < N; y++) {
	            if (map[x][y] != 0) {
	                if (idx > 0 && answer[x][idx - 1] == map[x][y] && lastMerged != idx - 1) {
	                    answer[x][idx - 1] *= 2;
	                    lastMerged = idx - 1;
	                } else {
	                    answer[x][idx] = map[x][y];
	                    idx++;
	                }
	            }
	        }
	    }
	}

	
	private static void goRight() {
	    for (int x = 0; x < N; x++) {
	        int idx = N - 1;
	        int lastMerged = -1; // 마지막으로 병합된 위치

	        for (int y = N - 1; y >= 0; y--) {
	            if (map[x][y] != 0) {
	                if (idx < N - 1 && answer[x][idx + 1] == map[x][y] && lastMerged != idx + 1) {
	                    answer[x][idx + 1] *= 2;
	                    lastMerged = idx + 1;
	                } else {
	                    answer[x][idx] = map[x][y];
	                    idx--;
	                }
	            }
	        }
	    }
	}

	


}
