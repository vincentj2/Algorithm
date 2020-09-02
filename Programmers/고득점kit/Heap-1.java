//더 맵게
class spicy{
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : scoville) {
            queue.offer(value);
        }

        while(queue.peek()<K) {
            if(queue.isEmpty()) {
                answer = -1;
                break;
            }
            int min = queue.poll();
            int second_min = queue.poll();
            queue.offer(min + (second_min * 2));
            answer+=1;
        }
        return answer;
    }
}
