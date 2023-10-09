import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class Main {
	public static int size;
	public static int[][] graph;
	
	public static int dx[] = {1, 0}; // 아래, 오른쪽
	public static int dy[] = {0, 1}; // 아래, 오른쪽
	
	
	public static String game(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();

			int move = graph[x][y];
			
			for(int i = 0; i < 2; i++) {
				int nx, ny;
				
				if(move == 1) {
					nx = x + dx[i];
					ny = y + dy[i];
				}
				else {
					if(dx[i] == 1) {
						nx = x + move;
						ny = y + dy[i];
					}
					else {
						nx = x + dx[i];
						ny = y + move;
					}
					
				}
				
				if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
				if(graph[nx][ny] == -1) return "HaruHaru";
				
				if(graph[nx][ny] > 0) {
					q.offer(new Node(nx, ny));
				}
				
			}
			
		}
		return "Hing";
		
		
	}
	
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		sc.nextLine();
		
		graph = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				graph[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		
		System.out.println(game(0, 0));
	}
}
