import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        k.solution(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
        System.out.println(k);
    }
}

class Solution {
    public void solution(int[][] matrix) {
        int n = matrix.length;
        for(int i=0 ; i<(n+1)/2; i++){
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}