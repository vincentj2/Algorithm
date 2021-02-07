package Algorthm.Programmers.고득점kit;

// H-Index
class HINDEX{
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        if (citations[citations.length - 1] == 0) {//논문 인용횟수가 모두 0 인 경우
            return answer;
        }
        int Max = 0;
        while (true) {
            int num = 0; //max번 이상 인용된 논문 수
            for (int citation : citations) {
                if (citation >= Max) {
                    num += 1;
                }
            }
            if(Max>num){
                answer = Max-1;
                break;
            }
            Max += 1;
        }
        return answer;
    }
}