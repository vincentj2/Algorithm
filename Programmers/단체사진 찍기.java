
import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(2,new String[]{"R~T>2","N~F=0"});
        System.out.println(answer);
    }
}

class Solution {
    static char[] friends = new char[]{'A','C','F','J','M','N','R','T'};
    static char[] position;
    static boolean[] check;
    static int answer;

    public int solution(int n, String[] data) {
        position = new char[8];
        check = new boolean[8];
        answer = 0;
        makeCase(0,n,data);
        return answer;
    }

    public void makeCase(int idx, int n, String[] data){
        if(idx==8){
            if(Ischeck(n,data)){
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!check[i]){
                check[i] = true;
                position[idx] = friends[i];
                makeCase(idx+1,n,data);
                check[i] = false;
            }
        }
    }

    public boolean Ischeck(int n, String[] data){
        for(int i=0; i<n; i++){
            int from=0;
            int to =0;
            for(int j=0; j<8; j++){
                if(data[i].charAt(0) == position[j]){
                    from = j;
                }
                else if(data[i].charAt(2) == position[j]){
                    to = j;
                }
            }
            int gap = Math.abs(to-from)-1;
            int cond = data[i].charAt(4)-'0';
            if(data[i].charAt(3)=='='){
                if(gap != cond) return false;
            }else if(data[i].charAt(3)=='>'){
                if(gap <= cond) return false;
            }else if(data[i].charAt(3)=='<'){
                if(gap >= cond) return false;
            }
        }
        return true;
    }
}