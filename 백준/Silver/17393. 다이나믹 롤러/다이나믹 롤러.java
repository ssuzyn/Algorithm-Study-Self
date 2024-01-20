import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<Long> A = new ArrayList<>();
	static List<Long> B = new ArrayList<>();

	public static int search(int start, long value) {
		int left = start;
		int right = N - 1;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(B.get(mid) < value || B.get(mid) == value) {
				left = mid + 1;
			}
			else if(B.get(mid) > value) {
				right = mid - 1;
			}
		}
		
		if(A.get(start) < B.get(mid))
			return mid - 1;
		
		return mid;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A.add(Long.parseLong(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B.add(Long.parseLong(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int index = search(i, A.get(i));
			sb.append(index - i).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
