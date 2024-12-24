import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(0, 0, (1 << N));
    }

    private static void solve(int x, int y, int size) {
        if (size == 1) {
            System.out.println(ans);
            return;
        }

        int newSize = size / 2;

        if (r < x + newSize && c < y + newSize) {
            solve(x, y, newSize);
        }
        else if (r < x + newSize && c >= y + newSize) {
            ans += (newSize * newSize);
            solve(x, y + newSize, newSize);
        }
        else if (r >= x + newSize && c < y + newSize) {
            ans += (newSize * newSize * 2);
            solve(x + newSize, y, newSize);
        }
        else {
            ans += (newSize * newSize * 3);
            solve(x + newSize, y + newSize, newSize);
        }
    }
}