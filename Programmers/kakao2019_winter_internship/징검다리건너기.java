package Algorthm.Programmers.kakao2019_winter_internship;

//징검다리 건너기 - 이진탐색
class bride{
    public int solution(int[] stones, int k) {
        int answer=0;
        int min = 2000000000;

        for(int i=0;i<= stones.length-k;){//k의 크기만큼 움직임
            int idx =0;
            int max = stones[i]; //첫 원소를 max 값으로 설정
            for(int j = i+1; j<i+k; j++){//k개중 첫항을 제외하고 탐색
                if(stones[j] >max){
                    max = stones[j];
                    idx=j;
                }
            }
            if(idx ==0 ) i++; //첫항이 가장 큰경우
            else i = idx+1;//첫항외에 큰 수가 있었다면 그 위치 다음부터 탐색
            min= Math.min(min,max);
        }
        answer = min;
        return answer;
    }
}