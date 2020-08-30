// 타겟 넘버
class target{ //DFS 사용 문제
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0);
        return answer;
    }
    //DFS 재귀
    public void dfs(int[] numbers, int target, int idx){
        if(idx == numbers.length){
            int sum =0;
            for(int i :numbers) sum += i;
            if(sum == target) answer +=1;
        }
        else{
            numbers[idx] *= 1;
            dfs(numbers ,target,idx+1);

            numbers[idx] *= -1;
            dfs(numbers, target,idx+1);
        }
    }
}
