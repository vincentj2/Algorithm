import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[][] answer = k.solution(5,new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
        System.out.println(Arrays.deepToString(answer));
    }
}

class Solution {
    private final int COL = 0, ROW = 1, NEW =1, DEL = 0;
    private boolean[][] rows, cols;
    private int n;
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        rows = new boolean[n+3][n+3];
        cols = new boolean[n+3][n+3];
        int cnt=0;
        for(int[] frame : build_frame){
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            if(frame[2]==COL){
                if(frame[3]==NEW && isPossibleCol(x,y)){
                    cols[x][y] = true;
                    cnt+=1;
                }
                if(frame[3]==DEL && isPossibleDel(x,y,COL)){
                    cols[x][y] = false;
                    cnt-=1;
                }
            }else if(frame[2]==ROW){
                if(frame[3]==NEW && isPossibleRow(x,y)){
                    rows[x][y] = true;
                    cnt+=1;
                }
                if(frame[3]==DEL && isPossibleDel(x,y,ROW)){
                    rows[x][y] = false;
                    cnt-=1;
                }
            }
        }
        int[][] answer = new int[cnt][3];
        int index =0;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (cols[i][j]) answer[index++] = new int[]{i - 1, j - 1, COL};
                if (rows[i][j]) answer[index++] = new int[]{i - 1, j - 1, ROW};
            }
        }
        return answer;
    }
    private boolean isPossibleCol(int x, int y){
        return y == 1 || cols[x][y - 1] || rows[x][y] || rows[x - 1][y];
    }
    private boolean isPossibleRow(int x, int y){
        return cols[x][y - 1] || cols[x + 1][y - 1] || (rows[x - 1][y] && rows[x + 1][y]);
    }
    private boolean isPossibleDel(int x, int y, int type){
        boolean result = true;
        if (type == COL) cols[x][y] = false;
        else rows[x][y] = false;

        loop:
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (cols[i][j] && !isPossibleCol(i, j)) {
                    result = false;
                    break loop;
                }
                if (rows[i][j] && !isPossibleRow(i, j)) {
                    result = false;
                    break loop;
                }
            }
        }
        if (type == COL) cols[x][y] = true;
        else rows[x][y] = true;

        return result;
    }
}