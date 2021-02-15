import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        boolean ans =k.solution("abcd","bbcd");
        System.out.println(ans);
    }
}

/*  2ms 37.7MB
    stack 사용
    '#' 인 경우 pop 그 외의 경우 push
    각 입력값에 대한 stack 구현 후 stack 데이터 비교
 */
class Solution {
    public boolean solution(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0; i<S.length();i++){
            char val = S.charAt(i);
            if(val != '#') stack1.push(val);
            else{
                if(stack1.isEmpty()) continue;
                stack1.pop();
            }
        }

        for(int i=0; i<T.length();i++){
            char val = T.charAt(i);
            if(val != '#') stack2.push(val);
            else{
                if(stack2.isEmpty()) continue;
                stack2.pop();
            }
        }
        return stack1.toString().equals(stack2.toString());
    }
}