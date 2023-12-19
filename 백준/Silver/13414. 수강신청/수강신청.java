import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        Set<String> studentId = new LinkedHashSet<>();

        for (int i = 0; i < size; i++) {
            String id = br.readLine();
            
            if(studentId.contains(id)) {
            	studentId.remove(id);
            }
            studentId.add(id);
        }

        int count = 0;
        for (String id : studentId) {
        	System.out.println(id);
            count++;
            if (count == max) break;
        }
        
	}
}
