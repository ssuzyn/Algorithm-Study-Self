import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]); // 과목의 수강 가능 인원
        int L = Integer.parseInt(input[1]); // 대기 목록의 길이

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++){
            String student = br.readLine();
            if(set.contains(student)){
                set.remove(student);
            }
            set.add(student);
        }

        for(String s : set){
            K--;
            System.out.println(s);
            if(K == 0) break;
        }

    }
}
