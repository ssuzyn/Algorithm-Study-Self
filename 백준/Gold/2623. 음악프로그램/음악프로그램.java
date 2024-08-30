import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] inDegree;
	static ArrayList<Integer>[] turn;
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static void topology() {
		Queue<Integer> q = new LinkedList<>();
		
        for(int i = 1; i <= N; i++) {
        	if(inDegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	answer.add(cur);
        	
        	for(int i = 0; i < turn[cur].size(); i++) {
        		int next = turn[cur].get(i);
        		inDegree[next] -= 1;
        		
        		if(inDegree[next] == 0) q.offer(next);
        	}
        }
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 가수의 수
        M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
        inDegree = new int[N + 1];
        turn = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) {
        	turn[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()); // 보조 PD가 정한 가수의 수
            
            
            int[] sequence = new int[count];
            for (int j = 0; j < count; j++) {
                sequence[j] = Integer.parseInt(st.nextToken()); // 가수 번호
            }

            for (int j = 0; j < count-1; j++) {
                int n1 = sequence[j]; // 가수 번호
                int n2 = sequence[j+1]; // 가수 번호
                turn[n1].add(n2); // n1 -> n2 순서
        		inDegree[n2]++;
            }
        }
        
        topology();
        
        if(answer.size() == N) {
        	for(int n : answer) {
    			System.out.println(n);
    		}
        }
        else {
        	System.out.println(0);
        }
        
        

	}

}
