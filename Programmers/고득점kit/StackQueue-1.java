package Algorthm.Programmers.고득점kit;//주식가격

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i =0; i<prices.length-1;i++){
            int val = prices[i];
            int cnt =0;
            for(int j = i+1;j<prices.length;j++){
                if(prices[j]<val){
                    cnt +=1;
                    answer[i] = cnt;
                    break;
                }
                cnt += 1;
            }
            answer[i] = cnt;
        }
        answer[prices.length-1] =0;
        return answer;
    }
}