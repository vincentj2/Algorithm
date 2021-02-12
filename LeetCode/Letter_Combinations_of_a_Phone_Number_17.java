import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        List<String>  ans =k.solution("23");
        System.out.println(ans);
    }
}
class Solution {
    String[][] letters = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    List<String> ans = new ArrayList<String>();

    public void backTrack(String combination, String next_digit){
        if(next_digit.length()==0){ //다음 추가될 알파벳이 없는경우
            ans.add(combination); //조합된 문자를 추가
        }
        else{
            String digit = next_digit.substring(0,1);
            int digit_num = Integer.parseInt(digit)-2;
            for(int i=0;i<letters[digit_num].length;i++){
                String temp = letters[digit_num][i];
                backTrack(combination+temp,next_digit.substring(1));//combination+temp 과정을 통해서 단어조합이 이뤄져야한다, 그렇지 않을 경우 combination의 자릿수가 계속 증가함
            }
        }
    }
    public List<String> solution(String digits) {
        if(digits.length()!=0){
            backTrack("", digits);
        }
        return ans;
    }
}