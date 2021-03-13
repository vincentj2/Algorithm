import java.util.*;


public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans = k.solution("ababcdcdababcdcd");
        System.out.println(ans);
    }
}
/*
풀이 내용
 */
class Solution {
    public int solution(String s) {
        if(s.length()==1) return 1;
        int ans = 1001;
        for(int i=1; i<=s.length()/2;i++){
            String now ="";
            String next="";
            String result="";
            int cnt =1;
            for(int j=0; j<=s.length()/i; j++){
                int start = i*j;
                int end = Math.min(i * (j + 1), s.length());
                now = next;
                next = s.substring(start,end);
                if(now.equals(next)) cnt++;
                else{
                    if(cnt>1){
                        result +=cnt+now;
                        cnt =1;
                    }
                    else{
                        result+=now;
                    }
                }
                // System.out.println("now: "+now+ " next : " + next+ " start :"+start+" end : "+end+ " result: "+result) ;
            }
            if(cnt>1){
                result +=cnt+next;
            }else{
                result += next;
            }
            // System.out.println(result);
            ans = Math.min(ans,result.length());
        }
        return ans;
    }
}