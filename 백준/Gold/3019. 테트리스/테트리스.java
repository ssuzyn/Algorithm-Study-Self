import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int C, P;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken()); // 열
		P = Integer.parseInt(st.nextToken()); // 블록의 번호
		arr = new int[C];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve());
	}

	private static int solve(){
		int ans = 0;

		if(P == 1){ // (1x4), (4x1) 도형
			ans += C;

			for(int i = 0; i <= C - 4; i++){
				ans += isSameLevel(i, 4);
			}
		}
		else if(P == 2){ // 정사각형
			for(int i = 0; i <= C - 2; i++){
				ans += isSameLevel(i, 2);
			}
		}
		else if(P == 3){
			for(int i = 0; i <= C - 3; i++){
				if(arr[i] == arr[i+1] && arr[i+1] + 1 == arr[i+2]) ans++;
			}

			for(int i = 0; i <= C - 2; i++){
				if(arr[i] == arr[i+1] + 1) ans++;
			}
		}
		else if(P == 4){
			for(int i = 0; i <= C - 3; i++){
				if(arr[i] == arr[i+1] + 1 && arr[i+1] == arr[i+2]) ans++;
			}

			for(int i = 0; i <= C - 2; i++){
				if(arr[i] + 1 == arr[i+1]) ans++;
			}
		}
		else if(P == 5){
			for(int i = 0; i <= C - 3; i++){ // ㅗ
				ans += isSameLevel(i, 3);
			}

			for(int i = 0; i <= C - 2; i++){ // ㅏ
				if(arr[i] + 1 == arr[i+1]) ans++;
			}

			for(int i = 0; i <= C - 3; i++){ // ㅜ
				if(arr[i] == arr[i+1] + 1 && arr[i+1] + 1 == arr[i+2]) ans++;
			}

			for(int i = 0; i <= C - 2; i++){ // ㅓ
				if(arr[i] == arr[i+1] + 1) ans++;
			}
		}
		else if(P == 6){
			for(int i = 0; i <= C - 3; i++){
				ans += isSameLevel(i, 3);
			}

			for(int i = 0; i <= C - 2; i++){
				ans += isSameLevel(i, 2);
			}

			for(int i = 0; i <= C - 3; i++){
				if(arr[i] + 1 == arr[i+1] && arr[i+1] == arr[i+2]) ans++;
			}

			for(int i = 0; i <= C - 2; i++){
				if(arr[i] == arr[i+1] + 2) ans++;
			}
		}
		else if(P == 7){
			for(int i = 0; i <= C - 3; i++){
				ans += isSameLevel(i, 3);
			}

			for(int i = 0; i <= C - 2; i++){
				if(arr[i] + 2 == arr[i+1]) ans++;
			}

			for(int i = 0; i <= C - 3; i++){
				if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2] + 1) ans++;
			}

			for(int i = 0; i <= C - 2; i++){
				ans += isSameLevel(i, 2);
			}

		}

		return ans;
	}

	private static int isSameLevel(int idx, int size){
		int h = arr[idx];
		for(int i = idx + 1; i < idx + size; i++){
			if(arr[i] != h) return 0;
		}

		return 1;
	}

}