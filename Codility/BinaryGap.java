import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans =k.solution(32);
        System.out.println(ans);
    }
}


class Solution {
    public int solution(int n) {
        int ans =0;
        int max =0;
        int flag =0;
        while(n != 0){
            int temp = n%2;
            n /=2;
           if(temp==1){
               if(flag ==0) flag =1;
               else {
                   ans = Math.max(ans, max);
                   max = 0;
               }
            }
            else if(temp ==0 && flag==1){
                max++;
            }
        }
        return ans;
    }
}

