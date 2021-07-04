import java.util.*;

//stack으로 제거해야하는 pattern 확인 후 제거

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String answer = k.solution("ixcupqoixcupqokevnpokevnpoknqywmlhevgc"	,"ixcupqokevnpo");
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String s, String part) {

        int parentLength = s.length();
        int patternLength = part.length();
        char[] parent = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<parentLength; i++){
            stack.push(parent[i]);
            if(stack.size()>=patternLength){
                for(int j=patternLength-1; j>=0; j--){
                    if(part.charAt(j)==stack.peek()){
                        stack.pop();
                    }else if(j<patternLength-1){
                        for(int k=j+1; k<patternLength;k++){
                            stack.push(part.charAt(k));
                        }
                        break;
                    }else{
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}