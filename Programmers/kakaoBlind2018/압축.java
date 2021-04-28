import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int[] answer = k.solution("ABABABABABABABAB");
        System.out.println(Arrays.toString(answer));
    }
}
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer_list = new ArrayList<>();
        List<String> index = new ArrayList<>();
        char temp = 'A';
        while(temp<='Z'){
            index.add(String.valueOf(temp));
            temp+=1;
        }

        for(int i=0; i<msg.length();){
            int idx=0;
            boolean flag = false;
            for(int j=i+1; j<=msg.length();j++){
                String sub = msg.substring(i,j);

                if(index.contains(sub)){
                    idx = index.indexOf(sub);
                    if(j == msg.length()){
                        answer_list.add(idx+1);
                        i = j+1;
                        flag = true;
                    }
                }else if(!index.contains(sub)){
                    index.add(sub);
                    answer_list.add(idx+1);
                    i = j-1;
                    flag = true;
                }

                if(flag){
                    break;
                }
            }
        }

        int[] answer = new int[answer_list.size()];
        for(int i=0; i< answer_list.size();i++){
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}