public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new int[][]{{-5}},1);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[][] matrix, int k) {

        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];

        while (min<=max){

            int mid = (min + max) / 2;
            int cnt =0;

            for (int[] ints : matrix) {
                for (int j = 0; j < n; j++) {
                    if (ints[0] > mid) break;
                    if (ints[j] <= mid) {
                        cnt++;
                    }
                }
            }

            if(cnt < k){
                min = mid +1;
            }else{
                max = mid -1;
            }
        }
        return min;
    }
}