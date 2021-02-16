import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String ans =k.solution("abacb");
        System.out.println(ans);
    }
}

/*  4ms 38.8MB
    Stack 사용
    Stack에 문자를 삽일할 때 stack에 존재 여부와 사전적 순서에 유의하여 push. pop 진행
 */
class Solution {
    public String solution(String s) {
        int[] array = new int[26]; //반복횟수 관리를 위한 배열 선언
        char[] letters = s.toCharArray();
        for(char c :letters){
            array[c-'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char letter : letters) {
            int idx = letter-'a';
            if (array[idx] > 0) {
                if (stack.contains(letter)) {
                    array[idx]--;
                }else if (stack.isEmpty() || stack.peek() <= letter) {
                    if (!stack.contains(letter)) {
                        stack.push(letter);
                    }
                    array[idx]--;
                }
                else {
                    while (!stack.isEmpty()) {
                        if (stack.peek() > letter && array[stack.peek() - 'a'] != 0)  {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    if (!stack.contains(letter)) {
                        stack.push(letter);
                        array[idx]--;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
