import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        long answer = k.solution("100-200*300-500+20");
        System.out.println(answer);
    }
}

class Solution {
    static char[] order = new char[]{'+', '-', '*'};
    static ArrayList<Long> num;
    static ArrayList<Character> operator;
    static Set<Character> orderList;
    static boolean[] visit;
    static long answer =0;
    public long solution(String expression) {
        int index =0;

        num = new ArrayList<>();
        operator = new ArrayList<>();
        orderList = new HashSet<>();
        for(int i=0; i<expression.length();i++){
            if(expression.charAt(i)=='*'|| expression.charAt(i)=='+' || expression.charAt(i)=='-'){
                if(!operator.contains(expression.charAt(i))){
                    orderList.add(expression.charAt(i));
                }
                operator.add(expression.charAt(i));
                num.add(Long.parseLong(expression.substring(index,i)));
                index = i+1;
            }
        }
        num.add(Long.parseLong(expression.substring(index)));
        visit = new boolean[3];

        dfs(0, new char[3]);
        return answer;
    }
    static long calculate(long num1, long num2, char operator){
        long temp=0;
        if(operator=='+'){
            temp = num1 + num2;
        }else if(operator == '-'){
            temp = num1 - num2;
        }else if(operator == '*'){
            temp = num1 * num2;
        }
        return temp;
    }

    static void dfs(int count, char[] priority){
        if(count == 3) {
            ArrayList<Long> cNums = new ArrayList<>(num);
            ArrayList<Character> cOps = new ArrayList<Character>(operator);
            for (char c : priority) {
                for (int j = 0; j < cOps.size(); j++) {
                    if (c == cOps.get(j)) {
                        Long res = calculate(cNums.remove(j), cNums.remove(j), c);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(!visit[i]) {
                visit[i] = true;
                priority[count] = order[i];
                dfs(count + 1, priority);
                visit[i] = false;
            }
        }
    }
}