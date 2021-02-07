package Algorthm.LeetCode;//695 Max Area of Island

class Solution {
    static int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        int answer =0;
        //좌상우하
        int[] x = {-1,0,1,0};
        int[] y = {0,-1,0,1};

        if(grid == null) return 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,x,y,i,j);
                    answer = Math.max(answer,max);
                    max=0;
                }
            }
        }
        return answer;
    }

    public void dfs(int[][] grid ,int[] x ,int[] y, int i, int j){
        max +=1;
        grid[i][j] = 0;
        for(int k=0; k<4; k++){
            if(i+x[k]>=0 && i+x[k]<grid.length && j+y[k] >=0 && j+y[k]<grid[0].length){
                if(grid[i+x[k]][j+y[k]] ==1){
                    dfs(grid,x,y,i+x[k],j+y[k]);
                }
            }
        }
    }
}