import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Gate {
        int flow;
        int cost;

        public Gate(int flow, int cost) {
            this.flow = flow;
            this.cost = cost;
        }
    }

    static int n, v, t, min;
    static Gate[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Gate[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Gate(f, c);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            combination(0, 0, 0, 0);

            sb.append("Case " + i + ": ").append(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min).append("\n");
        }

        System.out.println(sb);
    }

    private static void combination(int cnt, int start, int sum, int visit) {
        if (sum >= v) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if ((visit & (1 << i)) > 0) {
                    tmp += arr[i].cost;
                }
            }

            min = Math.min(min, tmp);
            return;
        }

        if (cnt == n) {
            return;
        }

        for (int i = start; i < n; i++) {
            if ((visit & (1 << i)) == 0) {
                combination(cnt + 1, i + 1, sum + arr[i].flow * t, (visit | (1 << i)));
            }
        }
    }

}
