package Algorthm.Programmers.고득점kit;

public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        int ans =k.solution(6, new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}});
        System.out.println(ans);
    }
}
class num6{
    public int solution(int n, int[][] edge) {
        int answer = 0;

        /*
        1. vertex를 통해 그래프를 완성한다.
        2. 1번에서 각 노드별 최단 거리를 구한다.
        3. 길이가 가장큰 거리의 수를 반환한다.

        POINT
        1. 그리프 그리기 -ArrayList에 해당 노드에 연결되는 노드 모두 저장
        2. 최단 거리 구하기 -bfs
        */

        //그래프 구현
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<edge.length;i++){
            list.add(new ArrayList<Integer>());
        }

        //노드연결
        for(int node[] : edge){
            int start = node[0];
            int end = node[1];
            list.get(start).add(end);
            list.get(end).add(start);
        }

        //1과의 거리 저장
        int cnt[] = new int[n+1];
        //방문 여부 체크
        boolean chk[] = new boolean[n+1];
        //진행중인 큐
        Queue<Integer> que = new LinkedList<>();
        que.add(1); //1과의 최단 거리 찾기 위해
        chk[0] = chk[1] = true;
        int now; // 현재 위치

        while(!que.isEmpty()){
            now= que.poll();
            for(int v:list.get(now)){//나와 연결된 노드들
                if(!chk[v]){//방문하지 않은 곳이라면
                    cnt[v]=cnt[now]+1;//1과의 길이 저장
                    chk[v]=true;
                    que.add(v);//이곳과 연결된 노드에 방문하기 위함
                }
            }
        }
        int max =0;
        for(int val : cnt){
            if(max<val){
                max = val;
                answer =1;
            }else if(max==val){
                answer++;
            }
        }
        return answer;
    }
}
