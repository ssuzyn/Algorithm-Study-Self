import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static class Lecture{
		int start;
		int end;

		public Lecture(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수업의 개수

		// 수업 시작 시간 순으로 정렬
		PriorityQueue<Lecture> lectures = new PriorityQueue<>((l1, l2) -> l1.start - l2.start);

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Integer> classrooms = new PriorityQueue<>();

		while(!lectures.isEmpty()){
			Lecture cur = lectures.poll();

			// 가장 빨리 끝나는 강의실에 배정 가능한지 확인
			if(!classrooms.isEmpty() && classrooms.peek() <= cur.start){
				classrooms.poll();
			}

			// 현재 강의의 끝나는 시간을 강의실에 추가
			classrooms.offer(cur.end);
		}

		// 강의실 개수 출력
		System.out.println(classrooms.size());

	}
}