import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        List<List<Integer>> ans =k.solution(new int[][] {{1,2},{3},{3},{}});
        System.out.println(ans);
    }
}
/*
DFS사용
노드의 갯수가 n이면 n-1까지 노드가 존재하기 때문에
dfs 반환 조건을 노드의 값이 길이와 같아지는 순간으로 지정
path가 결정되면 항상 add된 값을 제거 해주기!!
 */
class Solution {
    public  List<List<Integer>> solution(int[][] graph) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(path, 0, graph, answer);

        return  answer;
    }

    public void dfs(List<Integer> path, int node, int[][] graph,  List<List<Integer>> answer){

        if(node == graph.length-1){
            answer.add(new ArrayList<>(path));
            return;
        }
        for( int next : graph[node]){
            path.add(next);
            dfs(path,next,graph,answer);
            path.remove(path.size()-1);
        }
    }
}