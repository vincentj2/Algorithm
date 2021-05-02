
import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution("handshake","shake hands");
        System.out.println(answer);
    }
}

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        divideString(str1, multiSet1);
        divideString(str2, multiSet2);

        Collections.sort(multiSet1);
        Collections.sort(multiSet2);

        for(String s : multiSet1){
            if(multiSet2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        union.addAll(multiSet2);

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }

    private void divideString(String str1, ArrayList<String> multiSet1) {
        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                multiSet1.add(first + "" + second);
            }
        }
    }
}
