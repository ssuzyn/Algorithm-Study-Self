import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] count = new int[d + 1];
		int[] sushi = new int[N];
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int type = 0;
		for(int i = 0; i < k; i++) {
			if(count[sushi[i]] == 0) {
				type++; // 처음 카운팅하는 종류일 경우에만
			}
			count[sushi[i]]++; 
		}
		
		int ans = type;
		for(int start = 0; start < N; start++) {
			int end = (start + k) % N;
			
			// 왼쪽 초밥 제거
			if(count[sushi[start]] == 1) type--;
			
			count[sushi[start]]--;
			
			// 오른쪽 초밥 추가
			if(count[sushi[end]] == 0) type++;
			
			count[sushi[end]]++;
			
			// 쿠폰 초밥 포함한 최대 종류 수 갱신
			int maxType = type;
			if(count[c] == 0) maxType++;
			
			ans = Math.max(ans, maxType);
			
		}
		
		System.out.println(ans);
	}

}
