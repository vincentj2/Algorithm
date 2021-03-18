//시간초괴
import java.util.*;
public class solve {
    static int N;
    static int[][] map;
    static int[] isused1;
    static int[] isused2;
    static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isused1 = new int[2*N-1];
        isused2 = new int[2*N-1];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N ;j++){
                int num = sc.nextInt();
                map[i][j] = num;
            }
        }
        isPossible(0,0,0);
        System.out.println(answer);
    }
    static void isPossible(int col, int row, int cnt){
        answer=Math.max(cnt,answer);
        if(row>= N){
            col+=1;
            row = 0;
        }
        if(col >=N) return;
        if(map[col][row]!=0 && isused1[col+row]!=1 && isused2[col-row+N-1]!=1){
            isused1[col+row] = 1;
            isused2[col-row+N-1] =1;
            black_isPossible(col,row+1,cnt+1);
            isused1[col+row] = 0;
            isused2[col-row+N-1] =0;
        }
        isPossible(col,row+1,cnt);
    }
}