package Algorthm.Programmers.고득점kit;

class connectIsland{
    //크루스칼 알고리즘을 통해 해결, 유니온파인드 사용
    //Edge 클래스로 관리 cost 오름차순으로 정렬
    class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> que;
    //부모 노드 값 찾기
    public int find(int n){
        if(parent[n]== n ) return n;
        return  parent[n] = find(parent[n]);
    }
    //두 노드 유니온하기, 값이 작은쪽으로 연결해준다
    public void union(int a, int b){
        int A = find(a);
        int B = find(b);

        if(A<B) parent[B] = A;
        else parent[A] =B;

    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        que = new PriorityQueue<>();
        for (int i =0; i<costs.length;i++){
            Edge edge = new Edge(costs[i][0],costs[i][1],costs[i][2]);
            que.offer(edge);
        }
        //parent 초기화
        for(int i=0;i<n;i++){
            parent[i] =i;
        }

        while(!que.isEmpty()){
            Edge edge = que.poll();
            //부모 노드가 동일하면 이미 연결 되어 있다는 뜻
            if(find(edge.from) == find(edge.to)) continue;
                //연결되어있지 않다면 union 하여 cost 추가
            else{
                union(edge.from,edge.to);
                answer += edge.cost;
            }
        }
        return answer;
    }
}