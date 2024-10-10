import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, beer = 20;
	static int[][] map;
	static Node startNode, endNode;
	static List<Node> store;
	
	static class Node{
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine()); // 편의점 개수
        	map = new int[N][N];
        	
        	st = new StringTokenizer(br.readLine());
        	startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	
        	store = new ArrayList<>();
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		store.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	endNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	
        	goFestival();
        }
        
	}
	
	private static void goFestival() {
		Queue<Node> q = new LinkedList<>();
		q.add(startNode);
		boolean[] visited = new boolean[store.size()];
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(Math.abs(tmp.x - endNode.x) + Math.abs(tmp.y - endNode.y) <= beer * 50) {
				System.out.println("happy");
				return;
			}
			
			for(int i = 0; i < store.size(); i++) {
				
				if(visited[i]) continue;
				
				Node next = store.get(i);
				
				if(Math.abs(tmp.x - next.x) + Math.abs(tmp.y - next.y) <= beer * 50) {
					visited[i] = true;
					q.add(next);
				}
			}
		}
		
		System.out.println("sad");
		return;
	}
}
