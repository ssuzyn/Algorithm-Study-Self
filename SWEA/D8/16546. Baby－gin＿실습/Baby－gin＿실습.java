import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static int numbers[] = new int[6];
	static boolean babygin = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			for(int i = 0; i < 6; i++) {
				numbers[i] = str.charAt(i) - '0';
			}
			
			permutation(0);
			System.out.println("#" + t + " " + babygin);
			babygin = false;
		
		}
	}
	
	private static void swap(int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	public static void permutation(int idx) {
		if(babygin) {
			return;
		}
		
		if(idx == numbers.length) {
			
			int[] front = Arrays.copyOfRange(numbers, 0, 3);
			int[] back = Arrays.copyOfRange(numbers, 3, 6);
			
			boolean frontRun = checkRun(front);
			boolean frontTriplet = checkTriplet(front);
			boolean backRun = checkRun(back);
			boolean backTriplet = checkTriplet(back);
			
			babygin = (frontRun && backRun) || (frontRun && backTriplet) || 
	                  (frontTriplet && backRun) || (frontTriplet && backTriplet);
		
//			System.out.println(frontRun + " " + frontTriplet + " " + backRun + " " + backTriplet);
//			System.out.println(Arrays.toString(numbers) + " " + babygin + "\n");

			return;
		}
		
		for(int i = idx; i < numbers.length; i++) {
			swap(idx, i);
			permutation(idx + 1);
			swap(idx, i);
		}
	}
	
	public static boolean checkRun(int[] arr) {
		Arrays.sort(arr);
		return arr[1] == arr[0] + 1 && arr[2] == arr[1] + 1;
	}
	
	public static boolean checkTriplet(int[] arr) {
		return arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2];
	}
	
}
