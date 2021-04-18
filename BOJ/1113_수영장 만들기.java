import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solve {
    static int N;
    static int M;
    static int maxHeight;
    static int[][] map;
    static int flag;
    static Queue<int[]> queue;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int ans = 0;
        maxHeight = 1;
        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String st = sc.next();

            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(st.charAt(j));
                maxHeight = Math.max(maxHeight,map[i][j]);
            }
        }

        for(int height = 2; height <= maxHeight; height++) {

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++) {
                    visited[i][j] = false;
                }
            }

            for(int i = 1; i < N; i++) {
                for(int j = 1; j < M; j++) {
                    flag =0;
                    if(map[i][j] < height && !visited[i][j]) {
                        visited[i][j] = true;
                        queue.add(new int[] {i, j});
                        ans += dfs(height);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static int dfs(int height) {
        int pool = 1;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1) {
                    flag =1;
                    continue;
                }
                else if(!visited[nx][ny] && (map[nx][ny] < height)){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny});
                    pool++;
                }
            }
        }
        if(flag==1) return 0;
        return pool;
    }
}

