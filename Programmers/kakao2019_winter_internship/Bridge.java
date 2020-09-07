
class bride{
    public int solution(int[] stones, int k) {
        int answer=0;
        int min = 2000000000;

        for(int i=0;i<= stones.length-k;){
            int idx =0;
            int max = stones[i];
            for(int j = i+1; j<i+k; j++){
                if(stones[j] >max){
                    max = stones[j];
                    idx=j;
                }
            }
            if(idx ==0 ) i++;
            else i = idx;
            min= Math.min(min,max);
        }
        answer = min;
        return answer;
    }
}