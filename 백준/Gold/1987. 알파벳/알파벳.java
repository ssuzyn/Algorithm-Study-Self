import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, answer;
	static char[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i = 0; i < R; i++){
			map[i] = br.readLine().toCharArray();
		}

		answer = Integer.MIN_VALUE;
		boolean[] alphabet = new boolean[26];
		alphabet[map[0][0] - 'A'] = true;
		dfs(0, 0, 1, alphabet);

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int count, boolean[] alphabet){
		if(answer < count) answer = count;

		for(int[] d : dir){
			int nx = x + d[0];
			int ny = y + d[1];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

			int idx = map[nx][ny] - 'A';
			if(!alphabet[idx]){
				alphabet[idx] = true;
				dfs(nx, ny, count + 1, alphabet);
				alphabet[idx] = false;
			}
		}
	}

}