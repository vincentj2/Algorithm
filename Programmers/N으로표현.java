public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans = k.solution(2, 11);
        System.out.println(ans);
    }
}

class Solution {
    static int answer=Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(0,0,N,number);
        if(answer > 8) answer = -1;
        return answer;
    }

    static void dfs(int num ,int cnt, int N, int number){
        if(cnt>8) return;
        if(num == number){
            answer = Math.min(answer,cnt);
            return;
        }
        int temp = N;
        for(int i=0; i<8-cnt;i++){
            dfs(num+temp,cnt+i+1,N,number);
            dfs(num-temp,cnt+i+1,N,number);
            dfs(num/temp,cnt+i+1,N,number);
            dfs(num*temp,cnt+i+1,N,number);

            temp = temp * 10 + N;
        }
    }
}
