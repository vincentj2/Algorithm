import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] answer = k.solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int [][] map = new int[rows][columns];
        int idx =1;
        int [] diry={0,1,0,-1};
        int [] dirx={1,0,-1,0};

        for(int i=0; i<map.length;i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] =idx++;
            }
        }

        for(int i=0; i<queries.length; i++){
            int start_y = queries[i][0]-1;
            int start_x = queries[i][1]-1;
            int minnum = Integer.MAX_VALUE;
            int temp =0;

            for(int j=0; j<4; j++){
                if(j%2==0){
                    for(int p=0; p<queries[i][3]-queries[i][1]; p++){
                        int now_y = start_y + diry[j];
                        int now_x = start_x + dirx[j];
                        if(temp==0){
                            temp = map[now_y][now_x];
                            map[now_y][now_x] = map[start_y][start_x];
                            start_y = now_y;
                            start_x = now_x;
                        }else{
                            int temp2 = map[now_y][now_x];
                            map[now_y][now_x] = temp;
                            temp=temp2;
                            start_y = now_y;
                            start_x = now_x;
                        }
                        minnum = Math.min(minnum,temp);
                    }//p
                }else{
                    for(int k=0; k<queries[i][2]-queries[i][0]; k++){
                        int now_y = start_y + diry[j];
                        int now_x = start_x + dirx[j];
                        int temp2 = map[now_y][now_x];
                        map[now_y][now_x] = temp;
                        temp=temp2;
                        start_y = now_y;
                        start_x = now_x;
                        minnum = Math.min(minnum,temp);
                    }//k
                }//j-else
            }//j
            answer[i] = minnum;
        }//i
        return answer;
    }
}