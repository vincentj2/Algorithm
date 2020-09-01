//크레인 인형뽑기 게임
class game{
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (!result.empty()) {
                        if (result.peek() == board[j][move - 1]) {
                            answer += 2;
                            result.pop();
                            board[j][move - 1] = 0;
                            break;
                        }else {
                            result.push(board[j][move - 1]);
                            board[j][move - 1] = 0;
                            break;
                        }
                    }else {
                        result.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}