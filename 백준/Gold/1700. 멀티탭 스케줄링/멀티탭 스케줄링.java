import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tap;
	static int[] scheduler;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        tap = new int[N];
        scheduler = new int[K];
        for(int i = 0; i < K; i++) {
        	scheduler[i] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;
        for(int i = 0; i < K; i++) {
        	int tmp = scheduler[i];
        	boolean pass = false;
        	
        	for(int j = 0; j < N; j++) {
        		
        		if(tap[j] == tmp) { // 사용할 전기용품이 이미 꽂혀 있는 경우
        			pass = true;
        			break;
        		}
        		else if(tap[j] == 0) { // 빈자리가 있는 경우
        			tap[j] = tmp;
        			pass = true;
        			break;
        		}
        		
        	}
        	
        	if(!pass) {
        		int index = exchange(i + 1);
        		tap[index] = tmp;
        		count++;
        	}
        }
        
        System.out.println(count);
        
        
	}
	
	public static int exchange(int index) {
		int tapIndex = 0;
		int maxLater = -1;
		for(int i = 0; i < tap.length; i++) {
			int tmp = 0;
			for(int j = index; j < scheduler.length; j++) {
				if(scheduler[j] == tap[i]) break;
				tmp++;
			}
			
			if(tmp > maxLater) {
				tapIndex = i;
				maxLater = tmp;
			}
		}
		
		return tapIndex;
	}
	

}
