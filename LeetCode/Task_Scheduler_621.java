import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans =k.solution(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'},2);
        System.out.println(ans);
    }
}

/*  21ms 40.5MB
    Priority Queue 사용
    가장 많은 횟수의 알파벳이 idle 상태를 결정하고 최종 길이를 결정한다.
    우선순위큐에 반복 횟수가 높은 순으로 정렬하고
    n+1만큼 반복하며 횟수를 하나씩 줄여나간다.
    큐에 값이 존재 하는동안 n+1 즉 한 사이클 만큼의 시간을 추가하고 마지막에는 최종적으로 작동한 시간만 추가해준다.
 */
class Solution {
    public int solution(char[] tasks, int n) {
        int[] array = new int[26]; //알파벳 cnt 를 담기 위한 배열 선언
        int time =0;
        for(char task : tasks){
            array[task-'A']++;
        }
        //가장 높은 숫자 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : array) {
            if(i>0) pq.add(i);
        }
        //한 사이클은 돌면서 알파벳별 cnt를 줄여줌
        while(!pq.isEmpty()) {
            int temp_time =0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                    temp_time++;
                }
            }
            for (int i : temp) {
                if (--i > 0) pq.add(i);
            }
            //pq가 존재한다면 한 사이클 시간을 추가해준다 temp_time < n+1 인 경우는 idle 상태 발생
            if(!pq.isEmpty()){
                time += n+1;
            }else{
                //더이상 pq가 존재하지 않는다면 더이상 idle 상태가 발생하지 않고 작업이 끝이난다.
                time += temp_time;
            }
        }
        return time;
    }
}