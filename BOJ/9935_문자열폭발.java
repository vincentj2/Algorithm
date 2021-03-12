import java.util.*;

/*
   풀이 내용
   배열 인덱스 사용, target 문자를 하나씩 탐색하며 폭탄이 나타나는지 확인
   메모리: 31544kb
   시간: 552ms
*/
public class solve {

    static String target;
    static String boom;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        target = sc.next();
        boom = sc.next();
        char[] answer = new char[target.length()];
        int idx =0;
        for(int i=0; i<target.length();i++){
            answer[idx] = target.charAt(i);
            if(isBoom(answer,idx,boom)){
                idx -= boom.length();
            }
            idx++;
        }
        String ans = String.valueOf(answer,0,idx);
        if(ans.equals("")) System.out.println("FRULA");
        else System.out.println(ans);
    }
    static Boolean isBoom(char[] answer, int idx, String boom){
        if(idx <boom.length()-1) return false;
        for(int i=0; i<boom.length();i++){
            if(boom.charAt(i) != answer[idx-boom.length()+1+i]) return false;
        }
        return true;
    }
}