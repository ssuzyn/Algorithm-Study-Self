import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] day = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			day[i] = day[i-1] + Integer.parseInt(st.nextToken());
		}

		int maxVisitor = 0;
		int count = 0;
		for(int i = X; i <= N; i++){
			int visitor = day[i] - day[i - X];
			if(maxVisitor < visitor){
				maxVisitor = visitor;
				count = 1;
			}
			else if(maxVisitor == visitor){
				count++;
			}
		}

		if(maxVisitor == 0){
			System.out.println("SAD");
			return;
		}
		
		System.out.println(maxVisitor);
		System.out.println(count);
	}
}
