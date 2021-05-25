import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        char[] patterns = pattern.toCharArray();

        for(String str : words){
            boolean flag = false;
            HashMap<Character, Character> hm = new HashMap<>();
            char[] word = str.toCharArray();
            for(int i=0; i<patterns.length;i++){
                if(!hm.containsKey(patterns[i])){
                    if(hm.containsValue(word[i])){
                        flag = true;
                        continue;
                    }else{
                        hm.put(patterns[i],word[i]);
                    }
                }else if(hm.get(patterns[i])!=word[i]){
                    flag = true;
                    continue;
                }
            }
            if(!flag){
                answer.add(str);
            }
        }
        return answer;
    }
}