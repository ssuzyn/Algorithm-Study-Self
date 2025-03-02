import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static class Lecture{
        int pay;
        int day;

        Lecture(int pay, int day){
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10001];
        int answer = 0;

        PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> {
            return l2.pay - l1.pay; // 강연료로 내림차순
        });

        for(int i = 0; i < N; i++){
            String[] parts = br.readLine().split(" ");
            int pay = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            pq.add(new Lecture(pay, day));
        }

        while(!pq.isEmpty()){
            Lecture tmp = pq.poll();
            for(int i = tmp.day; i > 0; i--){
                if(!visited[i]){
                    visited[i] = true;
                    answer += tmp.pay;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
