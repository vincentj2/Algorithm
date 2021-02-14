import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans =k.solution(new int[] {4,3,2,1,5}, new int[] {1,0,1,1,0});
        System.out.println(ans);
    }
}
class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;

        for(int i=0;i<A.length;i++){
            if(B[i]==0 && stack.isEmpty()) ans++;
            else if(B[i]==1){
                stack.add(i);
            }
            else if(B[i]==0){
                if(A[stack.peek()] > A[i]){
                    continue;
                }else{
                    while(A[stack.peek()] < A[i]) {
                        stack.pop();
                        if(stack.isEmpty()) break;
                    }
                    if(stack.isEmpty()) ans++;
                }
            }
        }
        return stack.size()+ans;
    }
}