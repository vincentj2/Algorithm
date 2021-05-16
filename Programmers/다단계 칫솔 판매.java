import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] answer = k.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, String> refer = new HashMap<>();
        for(int i=0; i<enroll.length;i++){
            refer.put(enroll[i],referral[i]);
            hm.put(enroll[i],0);
        }

        for(int i=0; i< seller.length; i++){
            String name =seller[i];
            int cost = amount[i]*100;
            while(!name.equals("-")){
                int remain = (int) (cost * 0.1);
                if(remain<1){
                    hm.put(name,hm.get(name)+cost);
                    break;
                }else{
                    hm.put(name,hm.get(name)+ (cost-remain));
                    name = refer.get(name);
                    cost = remain;
                }
            }
        }

        for(int i=0; i< enroll.length;i++){
            answer[i] = hm.get(enroll[i]);
        }
        return answer;
    }
}