package Algorthm.Programmers.고득점kit;//모의고사
import java.util.*;


class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] num1 ={1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 =0;
        int cnt2 =0;
        int cnt3 =0;
        for(int i=0; i<answers.length; i++){
            if(num1[i%5]==answers[i]) cnt1 +=1;
            if(num2[i%8]==answers[i]) cnt2 +=1;
            if(num3[i%10]==answers[i]) cnt3 +=1;
        }
        int max = Math.max(cnt1,Math.max(cnt2,cnt3));

        List<Integer> list = new ArrayList<>();
        if(max == cnt1) list.add(1);
        if(max == cnt2) list.add(2);
        if(max == cnt3) list.add(3);

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = (int) list.get(i);
        }

        return answer;
    }
}