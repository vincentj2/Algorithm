import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] ans =k.solution(new int[]{2,7,11,15} , 9);
        System.out.println(Arrays.toString(ans));
    }
}


class Solution {

    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map  = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0 ; i< nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp)!= i){
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }

}

