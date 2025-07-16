import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;

	static class Egg{
		int power;
		int weight;

		Egg(int power, int weight){
			this.power = power;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Egg[] eggs = new Egg[N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		answer = Integer.MIN_VALUE;
		breakEgg(0, eggs, 0);
		System.out.println(answer);

	}

	static boolean isEggBroken(Egg egg){
		return egg.power <= 0;
	}

	static void breakEgg(int idx, Egg[] eggs, int broken){
		if(idx == N){
			answer = Math.max(answer, broken);
			return;
		}

		// 손에 든 계란이 깨진 경우
		if(isEggBroken(eggs[idx])){
			breakEgg(idx + 1, eggs, broken);
			return;
		}

		boolean status = true;
		for(int target = 0; target < N; target++){
			if(target == idx) continue;
			if(eggs[target].power > 0){
				status = false;
				eggs[target].power -= eggs[idx].weight;
				eggs[idx].power -= eggs[target].weight;

				int tmpBroken = broken;
				if(isEggBroken(eggs[target])) tmpBroken++;
				if(isEggBroken(eggs[idx])) tmpBroken++;
				breakEgg(idx + 1, eggs, tmpBroken);

				// 계란 내구도 원상복구
				eggs[target].power += eggs[idx].weight;
				eggs[idx].power += eggs[target].weight;
			}

		}

		// 깨지지 않은 다른 계란이 없는 경우
		if(status) breakEgg(idx + 1, eggs, broken);

	}
}