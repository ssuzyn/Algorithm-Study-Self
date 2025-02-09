import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        char[][] alphabet = new char[R][C];

        for(int i = 0; i < R; i++){
            alphabet[i] = br.readLine().toCharArray();
        }

        int start = 0;
        int end = R - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            HashSet<String> tmp = new HashSet<>();
            for(int i = 0; i < C; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = mid + 1; j < R; j++){
                    sb.append(alphabet[j][i]);
                }
                tmp.add(sb.toString());
            }
            if(tmp.size() != C) end = mid - 1;
            else start = mid + 1;

        }
        System.out.println(start);
    }
}
