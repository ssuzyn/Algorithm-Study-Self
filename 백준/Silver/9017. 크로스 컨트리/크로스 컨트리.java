import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Candidate{
		int teamNo;
		int totalScore;
		int fifth;

		Candidate(int teamNo, int totalScore, int fifth){
			this.teamNo = teamNo;
			this.totalScore = totalScore;
			this.fifth = fifth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] team = new int[201]; // 팀 자격 확인 배열
			int[] input = new int[N]; // 들어온 순서

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++){
				int tmp = Integer.parseInt(st.nextToken());
				input[i] = tmp;
				team[tmp]++;
			}

			// 출전 자격이 있는 팀 구분
			boolean[] flag = new boolean[201];
			for(int i = 1; i < team.length; i++){
				if(team[i] == 6) {
					flag[i] = true;
				}
			}

			// 자격을 갖춘 팀의 점수 메기기
			int[] score = new int[N];
			int rank = 1;
			for(int i = 0; i < N; i++){
				if(flag[input[i]]){
					score[i] = rank++;
				}
			}

			// 팀별로 점수 저장하기
			List<Integer>[] result = new ArrayList[201];
			for(int i = 1; i < team.length; i++){
				result[i] = new ArrayList<>();
			}

			for(int i = 0; i < N; i++){
				if(score[i] > 0){
					result[input[i]].add(score[i]);
				}
			}

			PriorityQueue<Candidate> pq = new PriorityQueue<>((t1, t2) -> {
				if(t1.totalScore == t2.totalScore){
					return t1.fifth - t2.fifth;
				}
				else return t1.totalScore - t2.totalScore;
			});

			for(int i = 1; i < team.length; i++){
				if(result[i].isEmpty()) continue;

				int totalScore = 0;
				for(int j = 0; j < result[i].size(); j++){
					if(j == 4){ // 5번째 선수인 경우 pq에 넣기
						pq.add(new Candidate(i, totalScore, result[i].get(j)));
					}
					totalScore += result[i].get(j);
				}
			}

			sb.append(pq.poll().teamNo).append("\n");
		}

		System.out.println(sb);
	}

}