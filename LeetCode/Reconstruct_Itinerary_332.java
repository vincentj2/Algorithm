import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        List<String>  ans =k.solution(new String[][] {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});
        System.out.println(ans);
    }
}

class Solution{
    public List<String>  solution(String[][] tickets) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(tickets, (o1,o2) ->{
            if(o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });
        System.out.println(Arrays.deepToString(tickets));
        ans.add("JFK");
        int[] visit = new int[tickets.length];
        int cnt =0;

        for(int i=0; i< tickets.length;i++){
            if(tickets[i][0].equals("JFK")){
                visit[i] =1;
                ans.add(tickets[i][1]);
                cnt++;
            }
        }
        while(cnt!= tickets.length){
            for(int i=0; i< tickets.length;i++){
                if(tickets[i][0].equals(ans.get(ans.size()-1)) && visit[i]==0){
                    visit[i]=1;
                    ans.add(tickets[i][1]);
                }
            }
        }
        return ans;

    }
}