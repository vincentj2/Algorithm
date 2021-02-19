import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String ans =k.solution("2[abc]3[cd]ef");
        System.out.println(ans);
    }
}
/*
stack 사용
Character.isDigit(char) -> char이 숫자일 경우 true
StringBuilder 사용시
StringBuilder sb = new StringBuilder(subString.pop());
파라미터 초기 할당
 */
class Solution {
    public String solution(String s) {
        Stack<String> subString = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String ans ="";
        int idx =0;

        while(idx<s.length()){
            //숫자일때
            if(Character.isDigit(s.charAt(idx))){
                int count =0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count*10 + (s.charAt(idx)-'0');
                    idx++;
                }
                countStack.push(count);
            }
            //'[' 일때
            else if(s.charAt(idx) =='['){
                subString.push(ans);
                ans ="";
                idx++;
            }
            //']' 일때
            else if(s.charAt(idx)==']'){
                StringBuilder sb = new StringBuilder(subString.pop());
                int repeat = countStack.pop();
                for(int i =0; i<repeat;i++){
                    sb.append(ans);
                }
                ans = sb.toString();
                idx++;
            }
            //문자 일때
            else{
                ans += s.charAt(idx);
                idx++;
            }
        }
        return ans;
    }
}