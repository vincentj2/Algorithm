import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        List<String> ans = k.solution(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"});
        System.out.println(ans);
    }
}

class Solution {
    public List<String> solution(String[] keyName, String[] keyTime) {
        HashMap<String , List<Integer>> hashMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for(int i=0; i< keyName.length;i++){
            if(!hashMap.containsKey(keyName[i])) {
                hashMap.put(keyName[i], new ArrayList<>());
            }
            String [] time = keyTime[i].split(":");
            int minute = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            hashMap.get(keyName[i]).add(minute);

        }
        for(String str : hashMap.keySet()){
            List<Integer> temp = hashMap.get(str);
            Collections.sort(temp);
            for(int j=0; j<hashMap.get(str).size()-2;j++){
                if(temp.get(j+1)-temp.get(j) <=60 && temp.get(j+2) - temp.get(j) <=60){
                    answer.add(str);
                    break;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}