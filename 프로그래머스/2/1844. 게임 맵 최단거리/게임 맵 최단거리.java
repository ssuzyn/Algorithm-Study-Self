import java.util.*;

class Node{
    int x;
	int y;
		
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
    
    int getX(){return this.x;}
    int getY(){return this.y;}
}

class Solution {
    int[][] visit;
	int[] dx = {0, 0, 1, -1};
	int[] dy = {-1, 1, 0, 0};
	int n, m;
	
	
	public boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public int bfs(int[][] maps, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(isValid(newX, newY) && visit[newX][newY] == 0 && maps[newX][newY] == 1) {
					visit[newX][newY] = visit[x][y] + 1;
					q.offer(new Node(newX, newY));
				}
			}
		}
		
		return visit[n-1][m-1];
	}
	
	
    public int solution(int[][] maps) {
    	
    	n = maps.length;
    	m = maps[0].length;
    	visit = new int[n][m];
    	
    	if(isValid(n-2, m-1) && isValid(n-1, m-2)) {
        	if(maps[n-2][m-1] == 0 && maps[n-1][m-2] == 0) return -1;
    	}
    	
        visit[0][0] = 1;
    	int answer = bfs(maps, 0, 0);
    	
    	if(answer == 0) return -1;
    	return answer;
    }
}