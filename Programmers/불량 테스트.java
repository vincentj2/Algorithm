import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        System.out.println(answer);
    }
}

class Solution {
    static int answer;
    static Set<Set<String>> set;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        set = new HashSet<>();
        makeCase(user_id,banned_id, new LinkedHashSet<>());
        answer = set.size();
        return answer;
    }

    static void makeCase(String[] user_id, String[] banned_id, Set<String> temp){
        if(temp.size()==banned_id.length){
            int idx=0;
            for(String str : temp){
                if(str.length() != banned_id[idx].length()){
                    return;
                }
                for(int i=0; i<str.length(); i++){
                    if(banned_id[idx].charAt(i)!= '*'){
                        if(str.charAt(i)!= banned_id[idx].charAt(i)) {
                            return;
                        }
                    }
                }
                idx+=1;
            }
            set.add(new HashSet<>(temp));
            return;
        }
        for(String str : user_id){
            if(!temp.contains(str)){
                temp.add(str);
                makeCase(user_id,banned_id,temp);
                temp.remove(str);
            }
        }
    }
}