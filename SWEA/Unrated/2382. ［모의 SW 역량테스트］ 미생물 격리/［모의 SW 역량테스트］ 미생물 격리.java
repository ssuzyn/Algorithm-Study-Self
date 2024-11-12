import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static Group[][] map;
	static PriorityQueue<Group> groupQ;

	static class Group implements Comparable<Group>{
		int x, y, micro, dir;

		Group(int x, int y, int micro, int dir) {
			this.x = x;
			this.y = y;
			this.micro = micro;
			this.dir = dir;
		}

		@Override
		public int compareTo(Group o) {
			return o.micro - this.micro; // 미생물 수가 큰 순서대로 정렬
		};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			groupQ = new PriorityQueue<>();
			map = new Group[N][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int micro = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1; // 상(0), 하(1), 좌(2), 우(3)
				Group group = new Group(x, y, micro, dir);
				groupQ.add(group);
			}

			for (int i = 1; i <= M; i++) {
				initMap();
				isolation();
				getCell();
			}

			int total = 0;
            for (Group g : groupQ) {
                total += g.micro;
            }
            
			sb.append("#" + tc + " " + total + "\n");
		}
		System.out.print(sb);
	}
	
	private static void initMap() {
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        map[i][j] = null;
		    }
		}
	}
	
	private static void getCell() {
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
				if(map[i][j] == null) continue;
				groupQ.add(map[i][j]);
			}
		}
	}

	private static void isolation() {
		PriorityQueue<Group> moveQ = new PriorityQueue<>();
		
		while(!groupQ.isEmpty()) { // 모든 군집 이동 처리
			Group cur = groupQ.poll();
			int nx = cur.x + dx[cur.dir]; // 다음으로 이동할 위치
			int ny = cur.y + dy[cur.dir];
			
			if(nx == 0 || ny == 0 || nx == N-1 || ny == N-1) {
				cur.micro /= 2;
				cur.dir = reverseDir(cur.dir);
			}
			
			if(cur.micro > 0) {
				cur.x = nx;
				cur.y = ny;
				moveQ.add(cur);
			}
		}
		
		while(!moveQ.isEmpty()) {
			Group cur = moveQ.poll();
			
			if(map[cur.x][cur.y] == null) {
				map[cur.x][cur.y] = cur;
			}
			else {
				map[cur.x][cur.y].micro += cur.micro;
			}
		}
	}

	private static int reverseDir(int dir) {
		int nextDir = dir;
		switch (dir) {
		case 0:
			nextDir = 1;
			break;
		case 1:
			nextDir = 0;
			break;
		case 2:
			nextDir = 3;
			break;
		case 3:
			nextDir = 2;
			break;
		}
		return nextDir;
	}

}
