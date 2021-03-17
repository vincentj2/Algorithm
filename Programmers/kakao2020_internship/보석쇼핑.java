import java.util.*;


public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] ans = k.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println(Arrays.toString(ans));
    }
}
/*
풀이 내용
 */
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int start =0;
        int end =0;
        int min_start =0;
        int length =Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        HashMap<String,Integer> check = new HashMap<>();

        set.addAll(Arrays.asList(gems));

        if(set.size()==1){
            answer = new int[]{1,1};
        }

        while(start< gems.length){
            if(end-start+1 > length || end== gems.length){
                if(check.get(gems[start])==1){
                    check.remove(gems[start]);
                }else{
                    check.put(gems[start], check.get(gems[start])-1);
                }
                start++;
            }else{
                if(!check.containsKey(gems[end])){
                    check.put(gems[end], 1);
                }else{
                    check.put(gems[end], check.get(gems[end])+1);
                }
                end++;
            }

            if(set.size() == check.size()){
                if(end-start < length){
                    length = end-start;
                    min_start = start;

                }else if(end-start == length){
                    if(min_start>start){
                        min_start = start;
                    }
                }
            }
        }
        answer[0] = min_start+1;
        answer[1] = min_start + length;
        return answer;

    }
}