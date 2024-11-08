import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // (0, 1: 가로), (2, 3: 세로)
    static int x1, y1, x2, y2;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + 100;
            y1 = Integer.parseInt(st.nextToken()) + 100;
            x2 = Integer.parseInt(st.nextToken()) + 100;
            y2 = Integer.parseInt(st.nextToken()) + 100;

            visited = new boolean[201][201][4];
            int answer = move();
            
            System.out.println("#" + t + " " + answer);

        }
    }

    private static boolean isValid(int x, int y) {
    	return x >= 0 && y >= 0 && x < 201 && y < 201;
    }

    private static int move() {
    	Queue<int[]> q = new LinkedList<>();
    	
    	// 초기 위치와 방향 추가: {x, y, 이동 횟수, 현재 방향}
    	q.add(new int[] {x1, y1, 0, 0}); // 가로 방향
    	q.add(new int[] {x1, y1, 0, 1}); // 세로 방향
    	visited[x1][y1][0] = true;
    	visited[x1][y1][2] = true;

    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int x = cur[0];
            int y = cur[1];
            int move = cur[2];
            int dirFlag = cur[3];
           
            if(x == x2 && y == y2) return move;
            
            switch(dirFlag) {
            case 0: // 세로로 가야함
            	for(int i = 2; i < 4; i++) {
            		int nx = x + d[i][0];
            		int ny = y + d[i][1];
            		
            		if(isValid(nx, ny) && !visited[nx][ny][i]) {
            			visited[nx][ny][i] = true;
            			q.add(new int[] {nx, ny, move + 1, 1}); 
            		}
            	}
            	break;
            case 1: // 가로로 가야함
            	for(int i = 0; i < 2; i++) {
            		int nx = x + d[i][0];
            		int ny = y + d[i][1];
            		
            		if(isValid(nx, ny) && !visited[nx][ny][i]) {
            			visited[nx][ny][i] = true;
            			q.add(new int[] {nx, ny, move + 1, 0}); 
            		}
            	}
            	break;
            }
    	}
    	
    	return -1;
    }
}