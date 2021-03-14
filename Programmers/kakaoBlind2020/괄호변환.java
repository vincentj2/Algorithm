import java.util.*;


public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String ans = k.solution("()))((()");
        System.out.println(ans);
    }
}
/*
풀이 내용
 */
class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return answer; //1번

        char[] word = p.toCharArray();
        int open =0;
        int close=0;
        String u = "";
        String v = "";

        //2번
        for(int i=0; i< word.length;i++){
            if(word[i]=='(') open++;
            else close++;
            if(open==close){
                u=String.valueOf(word,0,i+1);
                v=String.valueOf(word,i+1, word.length-i-1);
                break;
            }
        }

        //3번
        if(isBalance(u)){
            //3-1번
            answer = u + solution(v);
        }
        //4번
        else{
            String temp = "(";
            temp += solution(v);
            temp += ")";
            String temp2 ="";
            u = u.substring(1,u.length()-1);
            for(int i=0; i< u.length();i++){
                if(u.charAt(i)=='(') temp2 += ")";
                else temp2 += "(";
            }
            temp += temp2;
            answer = temp;
        }
        return answer;
    }
    static boolean isBalance(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i)==')' && stack.isEmpty()) return false;
            if(u.charAt(i)=='(') stack.push('(');
            else if(u.charAt(i)==')' && stack.peek()=='(') stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}