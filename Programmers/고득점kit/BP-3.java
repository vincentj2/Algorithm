//카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int x=1;
        int y=0;
        while(true){
            if(total%x !=0){
                x+=1;
            }
            else {
                y = total / x;
                if ((x >= y) && ((x+y)*2-4 == brown)) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                } else {
                    x += 1;
                }
            }
        }
        return answer;
    }
}