import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static String set1 = "CEFGHIJKLMNSTUVWXYZ";
    static String set2 = "ADOPQR";
    static String set3 = "B";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            String input1 = st.nextToken();
            String input2 = st.nextToken();
            String result = "SAME";
            if(input1.length() != input2.length()){
                result = "DIFF";
            }
            else{
                for(int i = 0; i < input1.length(); i++){
                    if(compare(input1.charAt(i)) != compare(input2.charAt(i))){
                        result = "DIFF";
                        break;
                    }
                }
            }
            

            
            sb.append("#" + t + " " + result + "\n");
            
        }

        System.out.println(sb);
    }

    static int compare(char ch){
        if(set1.contains(String.valueOf(ch))) return 1;
        if(set2.contains(String.valueOf(ch))) return 2;
        if(set3.contains(String.valueOf(ch))) return 3;
        return -1;
    }
}
