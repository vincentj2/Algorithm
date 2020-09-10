
class camera{
    class Route implements Comparable<Route>{
        int in;
        int out;
        Route(int in,int out){
            this.in = in;
            this.out = out;
        }
        @Override
        public int compareTo(Route o) {
            return this.in - o.in;
        }
    }

    static int min;
    static int max;
    public int solution(int[][] routes) {
        //1. routes의 진입지점을 오름차순 정렬
        //2. 진입지점이 가장 작은 곳 부터 시작
        //3. 다음 진입지점이 현재 나가는 지점보다 크면 answer 1 추가
        //4. 3번이 아니면 진입지점은 둘중에 크값 나간 지점은 둘중 작은 값 -> 공통 범위 지정
        int answer = 1;
        PriorityQueue<Route> que= new PriorityQueue<>();

        for (int[] ints : routes) {
            Route route = new Route(ints[0], ints[1]);
            que.offer(route);
        }
        Route present = que.poll();
        min = present.in;
        max = present.out;
        for(int i=1; i<routes.length; i++){
            Route next = que.poll();
            int in = next.in;
            int out = next.out;
            if(in>max || out<min){ //out<min은 역주행 케이스
                answer +=1;
                min = in;
                max = out;
            }else{
                min =Math.max(min,in);
                max = Math.min(max, out);
            }
        }
        return answer;
    }
}