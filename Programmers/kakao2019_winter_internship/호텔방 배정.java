import java.util.*;
/*
유니온 파인드 사용
크기 조건으로 인해 배열로 생성할 경우 메모리 초과 발생
HashMap으로 노드와 부모노드 사용
 */
class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Long> hm = new HashMap<>();
        for(int i=0; i<room_number.length;i++){
            long num = room_number[i];
            if(!hm.containsKey(num)){
                answer[i] = num;
                hm.put(num,num+1);
            }else{
                List<Long> list = new ArrayList<>();
                while(hm.containsKey(num)){
                    list.add(num);
                    num = hm.get(num);
                }
                System.out.println(list);
                answer[i] = num;
                hm.put(num,num+1);
                for(Long l : list){
                    hm.put(l,num+1);
                }
            }
        }
        return answer;
    }
}