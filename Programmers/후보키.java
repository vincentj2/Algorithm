import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
        System.out.println(answer);
    }
}


class Solution {
    static ArrayList<Set<Integer>> candidate_key;
    static boolean[] used;
    static int column;
    static int answer;

    public int solution(String[][] relation) {
        answer = 0;
        column = relation[0].length;
        candidate_key = new ArrayList<>();
        used = new boolean[column];

        for(int i=1; i<=column; i++){
            Set<Integer> temp = new HashSet<>();
            makeCandidateKey(i,0,relation,temp);
        }
        answer = candidate_key.size();
        return answer;
    }

    static void makeCandidateKey(int size, int cnt, String[][] relation, Set<Integer> temp){
        if(cnt==size){
            for(Set<Integer> candidate : candidate_key){
                if(temp.containsAll(candidate)){
                    return;
                }
            }

            if(isPossible(temp,relation)){
                candidate_key.add(temp);
            }
            return;
        }
        for(int i=0; i<column;i++){
            if(!used[i]){
                used[i] = true;
                /* 이렇게 하면 틀림
                temp.add(i);
                makeCandidateKey(size,cnt+1,relation,newSet);
                used[i] = false;
                temp.remove(i)
                 */
                Set<Integer> newSet = new HashSet<>(temp);
                newSet.add(i);
                makeCandidateKey(size,cnt+1,relation,newSet);
                used[i] = false;
            }
        }
    }

    static boolean isPossible(Set<Integer> BeCandidateKey, String[][] relation){
        HashMap<String, String> temp = new HashMap<>();

        for (String[] strings : relation) {
            String key = "";
            for (int j : BeCandidateKey) {
                key += strings[j];
            }
            if (temp.containsKey(key)) return false;
            else temp.put(key, key);
        }
        return true;
    }
}