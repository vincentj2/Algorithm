//기능개발

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //리스트 선언, .answerlist 인덱스 사용해서 배열에 옮기기
        ArrayList<Integer> daytime = new ArrayList<>();
        ArrayList<Integer> answerlist = new ArrayList<>();
        //작업 기간 계산
        for(int i=0; i<progresses.length;i++){
            int amt = progresses[i];
            int date=0;
            while(amt<100){
                amt  += speeds[i];
                date += 1;
            }
            daytime.add(date);
        }
        //현재 작업 기간보다 더 걸리는 작업 기간 확인해서 cnt 결정
        int max = daytime.get(0);
        int cnt = 1;
        int idx = 0;
        for(int j=1;j<daytime.size();++j){
            if(max<daytime.get(j)){
                max = daytime.get(j);
                answerlist.add(cnt);
                cnt = 1;
            }
            else
                cnt += 1;
        }
        //마지막 남은 cnt 저장
        answerlist.add(cnt);
        //리스트를 배열로 옮기기
        int[] answer = new int[answerlist.size()];
        for(int i=0;i<answerlist.size();i++){
            answer[i] = answerlist.get(i);
        }
        return answer;
    }
}