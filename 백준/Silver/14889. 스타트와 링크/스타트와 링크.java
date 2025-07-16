import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[][] power;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		answer = Integer.MAX_VALUE;
		selected = new boolean[N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(answer);
	}

	static void getTeamPower(){
		int sumA = 0, sumB = 0;

		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(selected[i] && selected[j]){
					sumA += power[i][j] + power[j][i];
				}
				else if(!selected[i] && !selected[j]){
					sumB += power[i][j] + power[j][i];
				}
			}
		}

		answer = Math.min(answer, Math.abs(sumA - sumB));

		if(answer == 0){
			System.out.println(answer);
			System.exit(0);
		}
	}

	static void combi(int cnt, int start){
		if(cnt == N / 2){
			getTeamPower();
			return;
		}

		for(int i = start; i < N; i++){
			selected[i] = true;
			combi(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

}