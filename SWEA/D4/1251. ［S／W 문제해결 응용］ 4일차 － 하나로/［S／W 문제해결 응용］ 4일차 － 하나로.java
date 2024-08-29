import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }

    }

    

    static void make() {
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    static int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 섬의 개수
            double[] X = new double[N];
            double[] Y = new double[N];
            PriorityQueue<Edge> edges = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                X[i] = Double.parseDouble(st.nextToken()); // 섬의 x좌표
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
            	Y[i] = Double.parseDouble(st.nextToken()); // 섬의 y좌표
            }

            double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

            // 모든 간선의 거리를 계산하여 리스트에 추가
            for (int i = 0; i < N-1; i++) {
                for (int j = i + 1; j < N; j++) {
                    double distance = E * (Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
                    edges.add(new Edge(i, j, distance));
                }
            }

            make();
            double cost = 0;
            int cnt = 0;

            while(!edges.isEmpty()) {
                Edge edge = edges.poll();

                if(union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if(++cnt == N - 1) break;
                }
            }

            System.out.println("#" + t + " " + Math.round(cost)); // 정수로 반올림하여 출력
        }

    }

}
