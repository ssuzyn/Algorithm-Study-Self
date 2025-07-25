import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static int N;

	static class Person{
		int start, end;

		Person(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	static class Computer{
		int index, end;

		Computer(int index, int end){
			this.index = index;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> availableSeat = new PriorityQueue<>();

		PriorityQueue<Computer> computer = new PriorityQueue<>((c1, c2) -> {
			return c1.end - c2.end;
		});

		PriorityQueue<Person> people = new PriorityQueue<>((p1, p2) -> {
			if(p1.start != p2.start) return p1.start - p2.start;
			return p1.end - p2.end;
		});

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			people.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int seatNumber = 1;
		int[] seat = new int[N+1];

		while(!people.isEmpty()){
			Person cur = people.poll();

			while(!computer.isEmpty() && computer.peek().end < cur.start){
					availableSeat.add(computer.poll().index);
			}

			if(availableSeat.isEmpty()){
				seat[seatNumber]++;
				computer.add(new Computer(seatNumber, cur.end));
				seatNumber++;
			}
			else{
				int number = availableSeat.poll();
				seat[number]++;
				computer.add(new Computer(number, cur.end));
			}
		}

		System.out.println(seatNumber - 1);
		for(int i = 1; i < seatNumber; i++){
			System.out.print(seat[i] + " ");
		}

	}

}