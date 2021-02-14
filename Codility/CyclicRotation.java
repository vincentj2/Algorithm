import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[]  ans =k.solution(new int[] {-1,-2,-3,-1,-4,-5},4);
        System.out.println(Arrays.toString(ans));
    }
}
class Solution {
    public int[] solution(int[] A, int K) {
        int[] ans = new int[A.length];
        if(A.length ==0) return ans;
        if(A.length == K) return A;
        else if(A.length < K) K= K% (A.length);

        for(int i=0; i< (A.length-K); i++){
            ans[K+i] = A[i];
        }
        for(int i=0; i< K; i++){
            ans[i]= A[i+A.length-K];
        }
        return ans;
    }
}