import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int H, W, N;
    static char[][] map;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static char[] direction = {'^', 'v', '<', '>'}; // 방향에 따른 전차 모양
    static Tank tank;

    static class Tank{
        int x, y;
        int status;

        Tank(int x, int y, int status){
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for(int h = 0; h < H; h++){
                map[h] = br.readLine().toCharArray();
                for(int w = 0; w < W; w++){
                    if(map[h][w] == '^') tank = new Tank(h, w, 0);
                    else if(map[h][w] == 'v') tank = new Tank(h, w, 1);
                    else if(map[h][w] == '<') tank = new Tank(h, w, 2);
                    else if(map[h][w] == '>') tank = new Tank(h, w, 3);
                }
            }

            N = Integer.parseInt(br.readLine());
            for(char cmd : br.readLine().toCharArray()){
                battle(cmd);
            }

            System.out.print("#" + t + " ");
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    private static void move(int status){ // status : 바꿀 방향
        tank.status = status;
        map[tank.x][tank.y] = direction[status];
        int nx = tank.x + d[tank.status][0];
        int ny = tank.y + d[tank.status][1];

        if(isValid(nx, ny) && map[nx][ny] == '.') {
            map[nx][ny] = map[tank.x][tank.y];
            map[tank.x][tank.y] = '.';
            tank.x = nx;
            tank.y = ny;
        }

    }

    private static void fire(){
        int nx = tank.x;
        int ny = tank.y;

        while(true){
            nx += d[tank.status][0];
            ny += d[tank.status][1];

            if(!isValid(nx, ny) || map[nx][ny] == '#') break;

            if(map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
        }
    }

    private static void battle(char cmd){

        switch(cmd) {
            case 'U':
                move(0);
                break;
            case 'D':
                move(1);
                break;
            case 'L':
                move(2);
                break;
            case 'R':
                move(3);
                break;
            case 'S':
                fire();
                break;
        }
    }
}
