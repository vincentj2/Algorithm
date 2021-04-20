public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String answer = k.solution("...!@BaT#*..y.abcdefghijklm"	);
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        boolean duplicate = false;
        for(int i=0; i<new_id.length(); i++){
            if(Character.isLetterOrDigit(new_id.charAt(i))){
                answer.append(Character.toLowerCase(new_id.charAt(i)));
                duplicate= false;
            }
            else if(new_id.charAt(i)=='-' || new_id.charAt(i)=='_' || new_id.charAt(i)=='.'){
                if(new_id.charAt(i)=='.'){
                    if(answer.length()==0 || duplicate) continue;
                    duplicate = true;
                }else {
                    duplicate = false;
                }
                answer.append(new_id.charAt(i));
            }
        }

        if(answer.length()==0){
            answer.append('a');
        }
        if(answer.length()>15){
            answer.delete(15, answer.length());
        }
        if(answer.charAt(answer.length()-1) =='.'){
            answer.deleteCharAt(answer.length()-1);
        }
        while(answer.length()<3){
            answer.append(answer.charAt(answer.length()-1));
        }

        return answer.toString();
    }
}