import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String[] answer = k.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "f-14 Tomcat"});
        System.out.println(Arrays.deepToString(answer));
    }
}

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] temp = divide(o1);
                String[] temp2 = divide(o2);
                int num = temp[0].toLowerCase().compareTo(temp2[0].toLowerCase());

                if(num ==0){
                    int number =  Integer.parseInt(temp[1]);
                    int number2 = Integer.parseInt(temp2[1]);
                    return number-number2;
                }else{
                    return num;
                }
            }
        });

        return files;
    }

    static String[] divide(String str){
        int idx=0;
        int idx2 =0;
        int flag =0;
        for(int j=0; j<str.length();j++){
            if(str.charAt(j) -'0' >=0 && str.charAt(j)-'0' <=9){
                if(flag==1){
                    continue;
                }
                idx = j;
                flag =1;
            }
            else if(flag==1){
                if(idx2 !=0){
                    break;
                }
                idx2 = j;
            }
        }
        String head = str.substring(0,idx);
        String number="";
        String tail="";
        if(idx2==0){
            number =str.substring(idx);
        }else{
            number =str.substring(idx,idx2);
            tail = str.substring(idx2);
        }

        return new String[]{head,number,tail};
    }
}