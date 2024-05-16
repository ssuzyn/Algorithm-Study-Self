import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class City implements Comparable<City>{
	int index;
	int cost;
	
	City(int index, int cost){
		this.index = index;
		this.cost = cost;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	@Override
	public int compareTo(City c) {
		return this.cost - c.cost;
	}
}


public class Main {
	
	public static final int INF = (int) 1e9;
	static ArrayList<ArrayList<City>> graph = new ArrayList<>();
	static int d[];
	static int city;
	
	
	
	public static void dijkstra(int start) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.offer(new City(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			City city = pq.poll();
			int dist = city.getCost();
			int now = city.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getCost();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
	}
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= city; i++) {
			graph.add(new ArrayList<City>());
		}
		
        StringTokenizer st;
        for(int i = 0; i < bus; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	graph.get(start).add(new City(end, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        
		d = new int[city + 1];
		Arrays.fill(d, INF);
		
		dijkstra(startCity);
		
		System.out.println(d[endCity]);
	}

}
