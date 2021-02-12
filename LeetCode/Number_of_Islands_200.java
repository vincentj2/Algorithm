class Solution {
    int[] x_pos = {-1, 0, 1, 0};
    int[] y_pos = {0, 1, 0, -1};

    public int solution(char[][] grid) {
        if (grid == null) return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int x, int y) {
        grid[x][y] = 'x';
        for (int i = 0; i < x_pos.length; i++) {
            if (x + x_pos[i] >= 0 && x + x_pos[i] < grid.length && y + y_pos[i] >= 0 && y + y_pos[i] < grid[0].length) {
                if (grid[x + x_pos[i]][y + y_pos[i]] == '1') {
                    dfs(grid, x + x_pos[i], y + y_pos[i]);
                }
            }
        }
    }
}