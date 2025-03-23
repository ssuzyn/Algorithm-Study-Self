import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Room{
    String roomType;
    int amount;
    ArrayList<Integer> nextRooms;
    boolean visit;

    Room(String roomType, int amount, ArrayList<Integer> nextRooms, boolean visit){
        this.roomType = roomType;
        this.amount = amount;
        this.nextRooms = nextRooms;
        this.visit = visit;
    }
}

public class Main{
    static boolean answer;
    static int N;
    static Room[] room;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = 0;
        while((N = Integer.parseInt(br.readLine())) != 0){
            room = new Room[N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String roomType = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                ArrayList<Integer> nextRooms = new ArrayList<>();
                int tmp = 0;
                while((tmp = Integer.parseInt(st.nextToken())) != 0){
                    nextRooms.add(tmp-1);
                }
                room[i] = new Room(roomType, amount, nextRooms, false);
            }
            answer = false;
            dfs(0, 0);
            if(answer) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int idx, int money){
        if(answer) return;

        if(idx == N-1){
            answer = true;
            return;
        }

        for(int next : room[idx].nextRooms){
            if(room[next].visit) continue;

            int amount = room[next].amount; // 다음 이동할 방의 통행료 or 금화
            switch(room[next].roomType){
                case "T":
                    if(money < amount) return;
                    money -= amount;
                    break;
                case "L":
                    if (money < amount) money = amount;
                    break;
            }

            room[next].visit = true;
            dfs(next, money);
            room[next].visit = false; // 백트래킹
        }

    }
}