public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
        System.out.println(answer);
    }
}
class Solution {
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] minCost;
    static int answer;


    public static void dfs(int[][] board, int row, int col, int cost, int dir) {
        //종료조건
        if (row == board.length - 1 && col == board.length - 1) {
            answer  = Math.min(answer, cost);
            return;
        }
        if(cost>answer)
            return;
        if(minCost[row][col]<cost)
            return;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board.length && board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                if (dir == -1 || dir == (i % 2)) { //기존방향 없거나 같은 경우.
                    if (minCost[nextRow][nextCol] >= cost + 100) {
                        minCost[nextRow][nextCol] = cost + 100;
                        dfs(board, nextRow, nextCol, cost + 100, i % 2);
                    }
                } else {
                    if (minCost[nextRow][nextCol] >=cost + 600) {
                        minCost[nextRow][nextCol] = cost + 600;
                        dfs(board, nextRow, nextCol, cost + 600, i % 2);
                    }
                }
                visited[nextRow][nextCol] = false;
            }
        }
    }

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        int boardSize = board.length;
        visited = new boolean[boardSize][boardSize];
        minCost = new int[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(board, 0,0,0,-1);

        return answer;
    }
}
