import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans = k.solution(5, new int[][]{{0,1,1},{3,4,1},{1,2,2},{2,3,4}});
        System.out.println(ans);
    }
}
//크루스칼 알고리즘 + 유니온파인드
class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int k=0; k<parents.length;k++){
            parents[k] = k;
        }

        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            if (find(start) != find(end)) {
                union(start, end);
                answer += cost[2];
            }
        }
        return answer;
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parents[aRoot] = b;
        }
    }
    static int find(int a){
        if(a==parents[a]) return a;
        else{
            parents[a] =  find(parents[a]);
        }
        return parents[a];
    }
}
