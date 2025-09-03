import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++){
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int step = 0;
		while(keepPower()){
			step++;
			rotateBelt();
			moveRobot();
			
			if(belt[start] > 0 && !robot[start]){
				robot[start] = true;
				belt[start]--;
			}
		}

		System.out.println(step);
	}

	private static boolean keepPower(){
		int count = 0;
		for(int i = 0; i < 2 * N; i++){
			if(belt[i] == 0) count++;
			if(count == K) return false;
		}
		return true;
	}

	private static void moveRobot(){
		if(robot[N-1]) robot[N-1] = false;

		for(int i = N - 2; i >= 0; i--){
			if(robot[i]){
				if(!robot[i + 1] && belt[i + 1] > 0){
					robot[i] = false;
					robot[i + 1] = true; // 로봇 이동
					belt[i + 1]--; // 내구도 감소
				}
			}
		}
	}

	private static void rotateBelt(){
		// 벨트 회전
		int tmp = belt[2 * N - 1];
		for(int i = 2 * N - 1; i >= 1; i--){
			belt[i] = belt[i - 1];
		}
		belt[0] = tmp;

		// 로봇도 같이 회전
		for(int i = N-1; i >= 1; i--){
			robot[i] = robot[i-1];
		}
		robot[0] = false; // 올리는 위치는 항상 빈 상태로
	}

}