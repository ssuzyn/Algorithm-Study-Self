import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10; // 테스트 케이스 개수

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < 8; i++){
                q.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 1;
            while(!q.isEmpty()){
                int tmp = q.poll() - cnt++;

                if(tmp <= 0){
                    q.add(0);
                    break;
                }

                if(cnt == 6) cnt = 1;
                q.add(tmp);
            }

            sb.append("#").append(N).append(" ");
            while(!q.isEmpty()){
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }
}
