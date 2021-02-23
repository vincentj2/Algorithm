import java.util.*;

/*
824ms 85116KB
DFS 사용
오른쪽 위, 오른쪽 오른쪽 아래 순으로 진행되어야 최대 갯수를 알 수 있다.
DFS를 수행하면서 마지막 열에 도달하면 1을 반환하여 result에 1을 더한다.

 */
public class solve {
    static int[] row_pos = new int[]{-1,0, 1};
    static int[] col_pos = new int[]{1, 1, 1};
    static int R ,C;
    static char[][] map;
    static int[][] visit;

    public static void main(String[] args){
        // 입출력 처리 //
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visit = new int[R][C];

        for(int i=0; i<R; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        // 입출력 처리 끝 //
        int result =0;

        for(int i=0; i<R ;i++){
            result += DFS(i,0);
        }
        System.out.println(result);
    }

    static int DFS(int i, int j){
        visit[i][j] = 1;
        if(j==C-1) return 1;

        for(int idx =0; idx<3; idx++){
            int x = j+col_pos[idx];
            int y = i+row_pos[idx];

            if(x>=0 && x<C && y>=0 &&y<R && visit[y][x]==0 && map[y][x] == '.'){
                int temp = DFS(y,x);
                if(temp==1) return 1;
            }
        }
        return 0;
    }
}