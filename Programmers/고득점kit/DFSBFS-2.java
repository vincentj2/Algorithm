package Algorthm.Programmers.고득점kit;

//네트워크
class network{
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i=0;i<n;i++){
            check[i]= false;
        }
        for(int i=0; i<n; i++){
            if(!check[i]) {
                dfs(i, computers, check);
                answer += 1;
            }
        }
        return answer;
    }
    //DFS 재귀구현
    public void dfs(int n, int[][] computers, boolean[] check){
        check[n] =true;
        for(int i=0; i<computers.length;i++){
            if(!check[i] && computers[n][i] ==1){
                dfs(i,computers,check);
            }
        }
    }
}

