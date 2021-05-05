import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        int length = t*m;
        int number =0;
        sb.append("0");
        while(sb.length()<=length){
            int temp = number;
            Stack<String> stack = new Stack<>();
            while(temp>0){
                int digit = temp%n;
                if(digit == 10){
                    stack.push("A");
                }else if(digit == 11){
                    stack.push("B");
                }else if(digit == 12){
                    stack.push("C");
                }else if(digit == 13){
                    stack.push("D");
                }else if(digit == 14){
                    stack.push("E");
                }else if(digit == 15){
                    stack.push("F");
                }else{
                    stack.push(Integer.toString(digit));
                }
                temp /= n;
            }

            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            number+=1;
        }
        String subResult = sb.toString();
        int idx = p-1;
        char[] ans = new char[t];
        for(int i=0; i<t; i++){
            ans[i] = subResult.charAt(idx+(m*i));
        }

        String answer = new String(ans);
        return answer;
    }
}