import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int BFS(int x, int y, char color){
        int power = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node tmpNode = queue.poll();
            x = tmpNode.x;
            y = tmpNode.y;

            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N){
                    if(!visited[nextX][nextY] && map[nextX][nextY] == color){
                        queue.offer(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                        power++;
                    }
                }
            }
        }

        return power;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 전쟁터 가로 크기
        M = Integer.parseInt(input[1]); // 전쟁터 세로 크기

        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int ourPower = 0;
        int enemyPower = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) { // 방문 하지 않은 곳 이라면
                    char color = map[i][j];
                    int result = BFS(i, j, color);

                    if (color == 'W') {
                        ourPower += result * result;
                    } else if (color == 'B') {
                        enemyPower += result * result;
                    }
                }
            }
        }

        System.out.println(ourPower + " " + enemyPower);
    }
}
