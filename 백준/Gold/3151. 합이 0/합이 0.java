import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int [] skill;
	
	static int lowerBound(int left, int right, int target){
        while(left<right){
            int mid = (left+right)/2;
            if(skill[mid] >= target) right = mid;
            else left = mid+1;
        }
        return right;
    }

    static int upperBound(int left, int right, int target){
        while(left<right){
            int mid = (left+right)/2;
            if(skill[mid] > target)  right = mid;
            else left = mid+1;
        }
        return right;
    }


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		skill = new int[N];
		for(int i = 0; i < N; i++) {
			skill[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(skill);
		long result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				int sum = skill[i] + skill[j];
				
				int lower = lowerBound(j + 1, N, -sum);
				int upper = upperBound(j + 1, N, -sum);
				
				result += upper - lower;
			}
		}
		
		System.out.println(result);
		
	}

}
