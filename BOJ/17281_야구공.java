import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve {
    static int ans;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] player =new int[N][9];
        for(int n = 0; n<N;n++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                player[n][i]= Integer.parseInt(st.nextToken());
            }
        }

        int [] order = new int[9];
        order[3] = 0;
        boolean[] visit =new boolean[9];
        visit[0] =true;
        permutation(0,visit, order, player);
        System.out.println(ans);
    }

    private static void permutation(int s,boolean[] visit, int[] order, int[][] player) {
        if(s==9) {
            int score = 0 ;
            int t =-1 ;
            for(int n = 0; n<N;n++) {
                int out = 0;
                int l1=0,l2=0,l3=0;
                while(out<3) {
                    t++;
                    if(t==9)t=0;
                    switch(player[n][order[t]]) {
                        case 0:
                            out++;
                            break;
                        case 4:
                            score+=l1+l2+l3+1;
                            l1=0;l2=0;l3=0;
                            break;
                        case 3:
                            score+=l3+l2+l1;
                            l3=1;l2=0;l1=0;
                            break;
                        case 2:
                            score+=l3+l2;
                            l3=l1;l2=1;l1=0;
                            break;
                        case 1:
                            score+=l3;
                            l3=l2;l2=l1;l1=1;
                            break;
                    }
                }
            }
            ans= Math.max(score,ans);
            return;
        }
        for(int i = 1; i<9;i++) {
            if(!visit[i]) {
                order[s] = i;
                visit[i] = true;
                if(s==2)permutation(4, visit, order, player);
                else permutation(s+1, visit, order, player);
                visit[i] = false;
            }
        }
    }
}