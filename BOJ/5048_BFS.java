import java.util.*;
public class solve {
    static int[] row_pos = new int[]{-1,0,0,1};
    static int[] col_pos = new int[]{0,1,-1,0};
    static int R ,C;
    static char[][] map;
    static int[][] visit;

    public static void main(String[] args){
        // 입출력 처리 //
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();

        map = new char[R][C];
        visit = new int[R][C];

        for(int i=0; i<R; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        // 입출력 처리 끝 //
        int result =0;

        for(int i=0; i<R ;i++){
            for(int j=0; j<C ;j++) {
                if(map[i][j]=='P'){
                    result = DFS(i,j);
                }
            }
        }
        System.out.println(result);
    }

    static int DFS(int i, int j){
        int gold =0;
        if(map[i][j] == 'G') gold++;
        if(map[i][j] == '#') return 0;
        visit[i][j] = 1;

        for(int k=0; k<4; k++) {
            int n_col = j + col_pos[k];
            int n_row = i + row_pos[k];
            if(n_col>=0 && n_col <C && n_row>=0 && n_row < R) {
                if (map[n_row][n_col] == 'T') return gold;
            }
        }

        for(int k=0; k<4; k++){
            int n_col = j+col_pos[k];
            int n_row = i+row_pos[k];
            if(n_col>=0 && n_col <C && n_row>=0 && n_row < R && visit[n_row][n_col]==0){
                gold += DFS(n_row,n_col);
            }
        }
        return gold;
    }
}