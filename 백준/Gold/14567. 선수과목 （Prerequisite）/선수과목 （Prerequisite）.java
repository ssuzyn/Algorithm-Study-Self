import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] subject;
    static int[] inDegree, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 과목의 수
        M = Integer.parseInt(st.nextToken()); // 선수 조건의 수

        subject = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        answer = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            subject[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            subject[a].add(b); // a는 b의 선수과목
            inDegree[b]++;
        }

        topology();
        for(int i = 1; i <= N; i++){
            System.out.print(answer[i] + " ");
        }

    }


    private static void topology(){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.add(new int[]{i, 1});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0]; // 과목 번호
            int term = cur[1]; // 학기

            answer[idx] = term;

            for(int i : subject[cur[0]]){
                inDegree[i]--;
                if(inDegree[i] == 0) q.add(new int[]{i, term + 1});
            }
        }
    }
}
