import java.util.*;

/*
   풀이 내용
   백트래킹, DFS 사용
   메모리: 20856kb
   시간: 440ms
   https://www.notion.so/BOJ-1062-67b45497aa3444c4945b6cd6a8819d6d
*/
public class solve {

    static int N ,K;
    static int[] used = new int[26];
    static String[] word;
    static int ans=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        word = new String[N];
        if(K<5) System.out.println(0);
        else if(K==26) System.out.println(N);
        else {
            used['a' - 'a'] = 1;
            used['n' - 'a'] = 1;
            used['t' - 'a'] = 1;
            used['i' - 'a'] = 1;
            used['c' - 'a'] = 1;
            K -=5;
            for(int i=0; i<N; i++) {
                word[i] = sc.next();
            }
            dfs(0,0);
            System.out.println(ans);
        }
    }

    static void dfs(int start, int cnt){
        if(cnt == K){
            int temp =0;

            for(int i=0; i<N;i++){
                boolean flag = true;
                for(int j=0; j<word[i].length();j++){
                    if(used[word[i].charAt(j)-'a'] == 0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    temp++;
                }
            }
            ans = Math.max(ans,temp);
        }

        for(int j=start; j<26; j++){
            if(used[j]==0){
                used[j] = 1;
                dfs(j,cnt+1);
                used[j] = 0;
            }
        }
    }
}
