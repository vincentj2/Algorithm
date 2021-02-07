package Algorthm.LeetCode;//200 Number of Islands

class Solution {
    public int numIslands(char[][] grid) {
        int answer =0;
        //좌상우하
        int[] x = {-1,0,1,0};
        int[] y = {0,-1,0,1};

        if(grid == null) return 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,x,y,i,j);
                    answer +=1;
                }
            }
        }

        return answer;
    }
    public void dfs(char[][] grid ,int[] x ,int[] y, int i, int j){
        grid[i][j] = 'x';
        for(int k=0; k<4; k++){
            if(i+x[k]>=0 && i+x[k]<grid.length && j+y[k] >=0 && j+y[k]<grid[0].length){
                if(grid[i+x[k]][j+y[k]] =='1'){
                    dfs(grid,x,y,i+x[k],j+y[k]);
                }
            }
        }
    }
}