package Algorthm.Programmers.고득점kit;//다리를 지나는 트럭
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int max =0;
        //  1. 큐가 비어있으면 트럭 무게를 추가한다.
        //  2. 트럭이 다리를 지났으면 큐의 크기는 다리의 길이와 동일 -> 큐에서 제거후 최대무게에서 뺌
        //  3. 큐가 비어있지 않고 무게가 부족하면 0을 추가
        //  4. 큐가 비어있지 않고 무게가 충분하면 트럭을 추가
        for(int w : truck_weights){
            while(0==0){
                if(que.isEmpty()){
                    que.offer(w);
                    max += w;
                    answer += 1;
                    break;
                }
                else if(que.size() == bridge_length){
                    max -= que.poll();
                }
                else{
                    if(max + w > weight){
                        que.offer(0);
                        answer += 1;
                    }
                    else{
                        que.offer(w);
                        max += w;
                        answer += 1;
                        break;
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}