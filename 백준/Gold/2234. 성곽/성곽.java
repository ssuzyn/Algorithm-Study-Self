import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int N, M;
    static int[] wall = {1, 2, 4, 8}; // 좌, 상, 우, 하
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[][] map;
    static int[][] roomId;
    static List<Integer> roomSize;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행

        map = new int[M][N];
        roomId = new int[M][N];
        roomSize = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCount = 1;
        int maxRoomSize = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(roomId[i][j] == 0){
                    int size = bfs(i, j, roomCount++);
                    roomSize.add(size);
                    maxRoomSize = Math.max(size, maxRoomSize);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount - 1).append("\n");
        sb.append(maxRoomSize).append("\n");
        sb.append(getMaxRoom()).append("\n");
        System.out.println(sb.toString());
    }

    private static int bfs(int x, int y, int roomCount){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        roomId[x][y] = roomCount;
        int size = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int d = 0; d < 4; d++){
                if((map[tmp[0]][tmp[1]] & wall[d]) != 0) continue; // 성벽이 있으면 패스
                int nx = tmp[0] + dir[d][0];
                int ny = tmp[1] + dir[d][1];
                if(roomId[nx][ny] != 0) continue; // 이미 방문한 곳이면 패스

                roomId[nx][ny] = roomCount;
                q.add(new int[]{nx, ny});
                size++;
            }
        }

        return size;
    }

    private static int getMaxRoom(){
        int combined = 0;

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                for(int d = 0; d < 4; d++){
                    if((map[i][j] & wall[d]) != 0){ // 벽이 있는 경우에만 확인
                        int nx = i + dir[d][0];
                        int ny = j + dir[d][1];
                        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        
                        if(roomId[i][j] != roomId[nx][ny]){ // 서로 다른 벽인 경우
                            combined = Math.max(roomSize.get(roomId[i][j] - 1) + roomSize.get(roomId[nx][ny] - 1), combined);
                        }
                    }
                }
            }
        }
        return combined;
    }
}