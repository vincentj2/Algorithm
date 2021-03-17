import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] ans = k.solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(Arrays.toString(ans));
    }
}
/*
BFS 사용

 */
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<int[]> queue = new LinkedList<>();
        int[] x_pos = new int[]{0,1,-1,0};
        int[] y_pos = new int[]{1,0,0,-1};
        int[][] used = new int[m][n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                int max =0;
                System.out.println(maxSizeOfOneArea);
                if(picture[i][j] !=0 && used[i][j]==0){
                    numberOfArea++;
                    queue.add(new int[] {i,j});
                    used[i][j] =1;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        max++;
                        for(int k=0;k<4;k++){
                            int x = temp[0]+x_pos[k];
                            int y = temp[1]+y_pos[k];
                            if(x>=0 && x<m && y>=0 && y<n && picture[x][y]== picture[temp[0]][temp[1]] && used[x][y]==0 && picture[x][y]!=0){
                                queue.add(new int[] {x,y});
                                used[x][y]=1;
                            }
                        }
                    }
                }
                if(max>maxSizeOfOneArea) maxSizeOfOneArea =max;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}