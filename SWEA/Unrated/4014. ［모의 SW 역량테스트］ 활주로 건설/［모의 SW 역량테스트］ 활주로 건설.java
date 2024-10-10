import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, X, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도 한 변의 길이
            X = Integer.parseInt(st.nextToken()); // 경사로 길이
            map = new int[N][N];
            count = 0;

            // 지도 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로, 세로 탐색
            for (int i = 0; i < N; i++) {
                if (rowSearch(i)) count++; // 가로 탐색
                if (colSearch(i)) count++; // 세로 탐색
            }

            System.out.println("#" + t + " " + count);
        }
    }

    // 가로 탐색
    private static boolean rowSearch(int row) {
        boolean[] visited = new boolean[N]; // 경사로 설치 여부 체크

        for (int i = 1; i < N; i++) {
            if (map[row][i - 1] != map[row][i]) {
                // 높이 차이가 1보다 크면 경사로 설치 불가
                if (Math.abs(map[row][i - 1] - map[row][i]) > 1) return false;

                // 오르막 경사로 설치
                if (map[row][i - 1] < map[row][i]) {
                    for (int j = 0; j < X; j++) {
                        if (i - j - 1 < 0 || map[row][i - 1] != map[row][i - j - 1] || visited[i - j - 1])
                            return false; // 경사로를 설치할 수 없는 경우
                        visited[i - j - 1] = true; // 경사로 설치
                    }
                }

                // 내리막 경사로 설치
                else {
                    for (int j = 0; j < X; j++) {
                        if (i + j >= N || map[row][i] != map[row][i + j] || visited[i + j])
                            return false; // 경사로를 설치할 수 없는 경우
                        visited[i + j] = true; // 경사로 설치
                    }
                }
            }
        }
        return true;
    }

    // 세로 탐색
    private static boolean colSearch(int col) {
        boolean[] visited = new boolean[N]; // 경사로 설치 여부 체크

        for (int i = 1; i < N; i++) {
            if (map[i - 1][col] != map[i][col]) {
                // 높이 차이가 1보다 크면 경사로 설치 불가
                if (Math.abs(map[i - 1][col] - map[i][col]) > 1) return false;

                // 오르막 경사로 설치
                if (map[i - 1][col] < map[i][col]) {
                    for (int j = 0; j < X; j++) {
                        if (i - j - 1 < 0 || map[i - 1][col] != map[i - j - 1][col] || visited[i - j - 1])
                            return false; // 경사로를 설치할 수 없는 경우
                        visited[i - j - 1] = true; // 경사로 설치
                    }
                }

                // 내리막 경사로 설치
                else {
                    for (int j = 0; j < X; j++) {
                        if (i + j >= N || map[i][col] != map[i + j][col] || visited[i + j])
                            return false; // 경사로를 설치할 수 없는 경우
                        visited[i + j] = true; // 경사로 설치
                    }
                }
            }
        }
        return true;
    }
}