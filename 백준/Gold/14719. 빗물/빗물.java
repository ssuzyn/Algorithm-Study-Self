import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int H = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      Stack<Integer> stack = new Stack<>();

      st = new StringTokenizer(br.readLine());
      int limit = Integer.parseInt(st.nextToken()); // 왼쪽 벽
      int totalRain = 0;

      // 1단계: 왼쪽→오른쪽, 높은 벽 만나면 물 계산
      for(int i = 1; i < W; i++){
         int tmp = Integer.parseInt(st.nextToken());

         if(tmp < limit) {
            stack.push(tmp);
         } else {
            // 오른쪽 벽 발견! 스택 비우며 물 계산
            while(!stack.isEmpty()){
               totalRain += limit - stack.pop();
            }
            limit = tmp;
         }
      }

      // 2단계: 남은 블록들 오른쪽→왼쪽 처리
      if(!stack.isEmpty()){
         int end = stack.pop(); // 오른쪽 벽

         while(!stack.isEmpty()){
            int tmp = stack.pop();
            if(tmp < end) {
               totalRain += end - tmp;
            } else {
               end = tmp; // 더 높은 벽 발견
            }
         }
      }

      System.out.println(totalRain);
   }
}