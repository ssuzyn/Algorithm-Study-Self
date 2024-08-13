import java.util.Scanner;

public class Solution {

    // 달팽이 회전 방향: 우 -> 하 -> 좌 -> 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = sc.nextInt();
            int[][] snail = new int[N][N];

            int value = 1;
            int x = 0, y = 0;
            int idx = 0; // 방향 전환을 위한 인덱스

            while(value <= N * N){
                snail[x][y] = value++;
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 방향 전환 = 좌표의 경계를 벗어나거나, 숫자가 이미 존재하는 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0){
                    idx = (idx + 1) % 4;
                }
                x = x + dx[idx];
                y = y + dy[idx];
            }

            System.out.println("#" + t);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
