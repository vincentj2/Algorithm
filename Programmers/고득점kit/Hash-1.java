package Algorthm.Programmers.고득점kit;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<participant.length; i++){
            if(!map.containsKey(participant[i]) ){
                map.put(participant[i],1);
            }else{
                map.put(participant[i], map.get(participant[i])+1);
            }
        }

        for(int j =0;j<completion.length; j++){
            map.put(completion[j],map.get(completion[j])-1);
        }
        for(String anw : map.keySet()){
            if(map.get(anw) == 1){
                answer = anw;
            }
        }
        //  answer = map.getKey(1);
        return answer;
    }
}