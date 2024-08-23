import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int minDiff = Integer.MAX_VALUE;
	static int people[];
	static boolean isSelected[];
	static List<Integer>[] matrix;

	 public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       N = Integer.parseInt(br.readLine()); // 구역의 개수
	       people = new int[N + 1]; // 각 구역의 인구 수 
	       matrix = new ArrayList[N + 1]; // 인접 행렬
	       isSelected = new boolean[N + 1];
	       
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       for(int i = 1; i <= N; i++) {
	    	   people[i] = Integer.parseInt(st.nextToken());
	       }
	       
	       for(int i = 1; i <= N; i++) {
	    	   matrix[i] = new ArrayList<>();
	       }
	       
	       for(int i = 1; i <= N; i++) {
	    	   st = new StringTokenizer(br.readLine());
	    	   int M = Integer.parseInt(st.nextToken()); // 해당 구역과 인접한 구역의 수
	    	   while(M-- > 0) {
	    		   int tmp = Integer.parseInt(st.nextToken());
	    		   matrix[i].add(tmp);
	    		   matrix[tmp].add(i);
	    	   }
	       }
	       
	       divide(1);
	       
	       if(minDiff == Integer.MAX_VALUE) {
	    	   System.out.println(-1);
	       }
	       else {
		       System.out.println(minDiff);
	       }
	       
	       
	 }
	 
	 private static void divide(int index) {
		 
		 if(index == N) { // 부분 집합 완성
			 
			 // 두 구역으로 나누기
			 List<Integer> groupA = new ArrayList<>();
			 List<Integer> groupB = new ArrayList<>();
			 
			 for(int i = 1; i <= N; i++) {
				 if(isSelected[i]) groupA.add(i);
				 else groupB.add(i);
			 }
			 
			 // 두 그룹 모두에 구역이 있어야 함
			 if(groupA.size() == 0 || groupB.size() == 0) return;
			 
			// 두 그룹이 각각 연결되어 있는지 확인
	            if (isConnected(groupA) && isConnected(groupB)) {
	                int sumA = 0, sumB = 0;
	                for (int i : groupA) sumA += people[i];
	                for (int i : groupB) sumB += people[i];
	                minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
	            }
			 
			 return;
		 }
		 
		 isSelected[index] = true;
		 divide(index + 1);
		 
		 isSelected[index] = false;
		 divide(index + 1);
	 }
	 
	 private static boolean isConnected(List<Integer> group) {
		 boolean[] visited = new boolean[N + 1];
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(group.get(0));
		 visited[group.get(0)] = true;
		 
		 int count = 1;
	        while (!queue.isEmpty()) {
	            int current = queue.poll();
	            for (int next : matrix[current]) {
	                if (group.contains(next) && !visited[next]) {
	                    visited[next] = true;
	                    queue.add(next);
	                    count++; // 인접한 구역인 경우 카운트
	                }
	            }
	        }
		 
		 return count == group.size(); // 인접한 구역의 갯수 = 현재 선거구에 포함된 구역의 갯수
	 }
}
