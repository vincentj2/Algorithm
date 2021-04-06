public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new int[]{8,20,6,2,20,17,6,3,20,8,12},5,4);
        System.out.println(answer);
    }
}
//prefix를 사용하여 미리 배열의 합을 계산

class Solution {
    public int solution(int[] A, int L, int M) {
        int answer =0;

        int[] prefixSum = new int[A.length+1];
        for(int i=0; i< A.length;i++){
            prefixSum[i+1] += prefixSum[i] + A[i];
        }

        //L다음 M이 나올때
        int answer1 = getAnswer(L, M, answer, prefixSum);
        //M다음 L이 나올때
        int answer2 = getAnswer(M, L, answer, prefixSum);

        return Math.max(answer1,answer2);
    }

    private int getAnswer(int L, int M, int answer, int[] prefixSum) {
        int maxL=0;
        for(int i= L+M; i<prefixSum.length;i++){
            maxL = Math.max(maxL, prefixSum[i-M]-prefixSum[i-M-L]);
            answer = Math.max(answer, maxL + prefixSum[i]-prefixSum[i-M]);
        }
        return answer;
    }
}