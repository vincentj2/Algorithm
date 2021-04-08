import java.util.*;

public class solve {

    static int[][] map;
    static int[][] copy; //같은 영역을 묶기위한 배열
    static boolean[][] visited;
    static int N,L,R;
    static int union = 0; //같은 영역 확인 위한 넘버
    static boolean flag = false;

    public static void main(String[] args){Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];
        copy = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        while (!flag) {
            visited = new boolean[N][N];
            flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(new Country(i, j));
                    }
                }
            }
            answer++;
        }
        System.out.println(answer-1);

    }
    //인구이동을 하는 함수 map에 변경된 인구를 갱신
    public static void move(int sum, int cnt) {
        flag = false;
        int avg = sum / cnt;

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == union) {
                    map[i][j] = avg;
                }
            }
        }
    }
    //인구이동이 가능한 영역끼리 묶음.
    public static void bfs(Country c) {
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int sum = 0;
        int cnt = 0;
        union++;
        Queue<Country> q = new LinkedList<>();

        q.add(c);
        sum += map[c.x][c.y];
        cnt++;

        while (!q.isEmpty()) {

            Country tmp = q.poll();
            visited[tmp.x][tmp.y] = true;
            copy[tmp.x][tmp.y] = union;

            for (int i = 0; i < 4; i++) {
                int sx = tmp.x + dx[i];
                int sy = tmp.y + dy[i];

                if (sx < 0 || sx >= N || sy < 0 || sy >= N) {
                    continue;
                }
                int diff = Math.abs(map[tmp.x][tmp.y] - map[sx][sy]);
                if ((diff < L || diff > R) || visited[sx][sy]) {
                    continue;
                }
                //조건에 만족할 경우
                q.add(new Country(sx, sy));
                visited[sx][sy] = true;
                copy[sx][sy] = union;
                sum += map[sx][sy];
                cnt++;
            }
        }
        if (cnt == 1)
            return;
        move(sum, cnt);
    }
}

class Country {
    int x;
    int y;

    Country(int x, int y) {
        this.x = x;
        this.y = y;
    }
}