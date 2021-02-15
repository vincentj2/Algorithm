import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] ans =k.solution(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ans));
    }
}

/*  15ms 46.9MB
    Stack 사용
    stack에는 T의 인덱스 값을 삽입, 제거
    stack의 마지막 값이 삽입 순서의 값보다 작으면 pop하고 현재 인덱스 - stack.peek() 인덱스를 계산하여
    ans 배열에 값을 추가한다
 */
class Solution {
    public int[] solution(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];

        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}