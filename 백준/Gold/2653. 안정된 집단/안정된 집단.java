import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 집단에 속한 사람들의 수
		int[][] relation = new int[N + 1][N + 1];

		for(int i = 1; i <= N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++){
				relation[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[N + 1];
		List<List<Integer>> groups = new ArrayList<>();

		for(int i = 1; i <= N; i++){
			if(visited[i]) continue;

			List<Integer> group = new ArrayList<>();
			group.add(i);
			visited[i] = true;

			for(int j = 1; j <= N; j++){
				if(i == j || visited[j]) continue;

				boolean canJoin = true;
				for(int member : group) {
					if (relation[j][member] == 1 || relation[member][j] == 1) {
						canJoin = false;
						break;
					}
				}

				if (canJoin) {
					group.add(j);
					visited[j] = true;
				}
			}

			if(group.size() < 2){
				System.out.println(0);
				return;
			}
			
			groups.add(group);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(groups.size()).append("\n");

		for(List<Integer> group : groups){
			for(int member : group){
				sb.append(member + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
