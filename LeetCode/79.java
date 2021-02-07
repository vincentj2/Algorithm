package Algorthm.LeetCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        boolean ans =k.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
        System.out.println(ans);
    }
}
class Solution {
    int[] dir_x = new int[]{-1, 0, 1, 0};
    int[] dir_y = new int[]{0,1,0,-1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int idx =0;
        for (int i=0; i<board.length;i++){
            for (int j=0; j<board[0].length;j++){
                if(dfs(board,word,visited,i,j,idx)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int idx){
        if(idx==word.length()) return true;
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 ) return false;
        if(visited[i][j]) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        visited[i][j]= true;
        for(int l=0; l<4;l++){
            int x = i + dir_x[l];
            int y = j + dir_y[l];
            if(dfs(board, word, visited, x, y,idx+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}