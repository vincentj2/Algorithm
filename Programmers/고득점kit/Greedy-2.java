// 큰 수 만들기
class bigNum{
    public String solution(String number, int k) {
        char[] input = number.toCharArray();

        // 스택, 작은 수 일수록 위에 존재한다.
        Stack<Character> temp = new Stack<>();
        for(int i = 0 ; i < input.length ; i++) {
            while(!temp.empty() && k > 0 && temp.peek() < input[i]) {
                k--;
                temp.pop();
            }
            temp.push(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        // k개를 삭제하지 못 한 경우 뒤에서 부터 제거.
        while(!temp.empty()) {
            if(k != 0) {
                temp.pop();
                k--;
            }else {
                sb.append(temp.pop());
            }
        }
        return sb.reverse().toString();
    }
}