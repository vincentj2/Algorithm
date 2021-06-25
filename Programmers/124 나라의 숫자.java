import java.util.*;


public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String answer = k.solution(15);
        System.out.println(answer);
    }
}

class Solution {
    static String[] digit = {"4","1","2"};

    public String solution(int n) {
        String answer = "";

        while(n>0){
            int remain = n%3;
            n = n/3;
            if(remain ==0){
                n -=1;
            }

            answer = digit[remain] +answer;
        }

        return answer;
    }
}
