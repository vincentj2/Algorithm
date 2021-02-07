package Algorthm.Programmers.고득점kit;//프린터
import java.util.*;

class printer{
    Integer priority;
    Integer idx;

    public printer(Integer priority, Integer idx){
        this.priority = priority;
        this.idx = idx;
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayList<printer> list = new ArrayList<>();
        ArrayList<printer> answerlist = new ArrayList<>();

        for(int i =0; i<priorities.length;i++){
            list.add(new printer(priorities[i],i));
        }

        while(list.size() != 0){
            printer a = list.get(0);
            int flag =0;
            if(list.size() == 1){
                answerlist.add(a);
                list.remove(0);
            }
            else{
                for(int k=1; k<list.size(); k++){
                    printer b = list.get(k);
                    if(a.priority<b.priority){
                        list.add(a);
                        list.remove(0);
                        flag =1 ;
                        break;
                    }
                }
                if(flag == 0){
                    answerlist.add(a);
                    list.remove(0);
                }
            }
        }

        for(int i=0;i<priorities.length;i++){
            printer c = answerlist.get(i);
            if(c.idx == location){
                answer = i;
                break;
            }
        }
        //첫번째가 0 이 아닌 1 -> 문제 정확히 읽기
        return answer+1;
    }
}