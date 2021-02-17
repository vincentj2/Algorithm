import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[][] ans =k.solution(new int[][] {{0,0,0},{0,0,0}}, 0,0,2);
        System.out.println(Arrays.deepToString(ans));
    }
}
/*
    bfs 사용 (queue)
    출발점으로 부터 4개 방향 확인하며 출발지 색상과 같은 경우 new color로 변경하며 bfs 진행
 */
class Solution {
    public int[][] solution(int[][] image, int sr, int sc, int newColor) {
        int[] x_pos = new int[] {-1,0,1,0};
        int[] y_pos = new int[] {0,-1,0,1};
        int og_color = image[sr][sc];

        int x_len = image.length;
        int y_len = image[0].length;
        int[][] visit = new int[x_len][y_len];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc});
        visit[sr][sc] = 1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i=0;i<x_pos.length;i++){
                if( x+x_pos[i]>=0 && x+x_pos[i]<x_len && y+y_pos[i]>=0 && y+y_pos[i]<y_len && visit[x+x_pos[i]][y+y_pos[i]] ==0 ){
                    if(image[x+x_pos[i]][y+y_pos[i]] == og_color){
                        queue.add(new int[] {x+x_pos[i],y+y_pos[i]});
                        visit[x+x_pos[i]][y+y_pos[i]] =1;
                        image[x+x_pos[i]][y+y_pos[i]] = newColor;
                    }
                }
            }
            image[x][y] =newColor;
        }
        return image;
    }
}
