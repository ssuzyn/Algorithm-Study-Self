import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
         
        List<List<Integer>> graph = new ArrayList<>();
         
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }
         
        for (int i = 1; i < node; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        
        boolean[] visited = new boolean[node+1];
        int[] parent = new int[node+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 루트 노드 1부터 탐색 시작
        
        while(!q.isEmpty()) {
        	int tmp = q.poll();
        	visited[tmp] = true;
        	
        	for(int i = 0; i < graph.get(tmp).size(); i++) {
        		int next = graph.get(tmp).get(i);
        		if(!visited[next]) {
        			q.add(next);
            		parent[next] = tmp;
        		}
        	}
        }
        
        for(int i = 2; i <= node; i++) {
        	System.out.println(parent[i]);
        }
        
    }
}
