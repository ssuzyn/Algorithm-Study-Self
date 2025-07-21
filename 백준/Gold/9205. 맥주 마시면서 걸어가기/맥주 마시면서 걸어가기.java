import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Point[] points;

	static class Point{
		int x; int y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(tc-- > 0){
			N = Integer.parseInt(br.readLine());
			points = new Point[N + 2];

			for(int i = 0; i < N + 2; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			if(bfs()) sb.append("happy\n");
			else sb.append("sad\n");
		}

		System.out.print(sb);
	}


	private static boolean bfs(){
		Queue<Point> q = new LinkedList<>();
		boolean[] visited = new boolean[points.length];
		visited[0] = true;
		q.add(points[0]);

		while(!q.isEmpty()){
			Point cur = q.poll();
			if(cur.x == points[N+1].x && cur.y == points[N+1].y) return true;

			for(int i = 0; i < N + 2; i++){
				if(visited[i]) continue;
				int dist = Math.abs(cur.x - points[i].x) + Math.abs(cur.y - points[i].y);
				if(dist <= 1000) {
					visited[i] = true;
					q.add(points[i]);
				}
			}
		}

		return false;
	}
}
