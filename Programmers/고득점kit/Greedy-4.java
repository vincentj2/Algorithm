class lifeboat{
    //첫 시도에는 복잡하게 생각해서 배열 내 합이 limit이 되는 값을 찾아서 제거 -> 남은 배열을 합을 고려해 답을 구하고 자 했다.
    //문제의 핵심은 sort후 최대값과 최소값의 합을 통해 판별하고 두개의 인덱스를 사용하면 쉽게 해결 할 수 있었다.
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j =0;
        for(int i= people.length-1; i>=j ; i--){
            if(people[j]+people[i]>limit){
                answer +=1;
            }
            else{
                answer +=1;
                j++;
            }
        }
        return answer;
    }
}
