import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans =k.solution("{[()()]}");
        System.out.println(ans);
    }
}
class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char str = S.charAt(i);
            if (str == '{' || str =='[' || str== '(') {
                stack.push(str);
            }else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char now = stack.pop();
                if (str == '}' && now != '{') {
                    return 0;
                } else if (str == ']' && now != '[') {
                    return 0;
                } else if (str == ')' && now != '(') {
                    return 0;
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
}