class diskController{

    public int solution(int[][] jobs) {
        int answer = 0;
        int num = jobs.length;
        int cnt =0; // 작업 횟수
        int idx = 0;//배열 인덱스
        int end =0; //작업 끝난 시간

        //input 작업 요청 시간 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        //작업 소요시간 오름차순 정렬
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        while(cnt<num){
            //작업이 끝나기 전에 요청되는 작업들 우선순위 큐에 저장
            while(idx< num && jobs[idx][0] <= end){
                heap.add(jobs[idx++]);
            }
            //우선순위 큐 비어있으면 다음 인덱스의 요청시간으로  end 지정
            if(heap.isEmpty()){
                end =jobs[idx][0];
            }else{
                int[] disk = heap.poll();
                answer += disk[1]+end-disk[0];
                end += disk[1];
                cnt++;
            }
        }
        answer = answer/num;
        return answer;
    }
}