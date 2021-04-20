import java.util.*;

/*public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        boolean answer = k.solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][]{{8,5},{6,7},{4,1}});
        System.out.println(answer);
    }
}
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        return answer;
    }
}*/


public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String[] answer = k.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4});
        System.out.println(Arrays.toString(answer));
    }
}
class Solution {
    static List<Map<String, Integer>> FoodMap = new ArrayList<>();
    static int[] FoodCnt = new int[11];

    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<11;i++){
            FoodMap.add(new HashMap<>());
        }

        for(String str : orders){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            combination(ch,0, new StringBuilder());
        }

        List<String> temp = new ArrayList<>();
        for(int i : course){
            for(  String str:  FoodMap.get(i).keySet()){
                if(FoodMap.get(i).get(str) == FoodCnt[i] && FoodCnt[i]>=2){
                    temp.add(str);
                }
            }
        }
        String[] answer = new String[temp.size()];
        Collections.sort(temp);
        for(int i=0; i< temp.size();i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }

    static void combination(char[] ch, int pos, StringBuilder sb){
        //종료조건
        if(pos>= ch.length){
            if(sb.length()>=2) {

           /*   int cnt = FoodMap.get(sb.length()).getOrDefault(sb.toString(),0)+1;
                FoodMap.get(sb.length()).put(sb.toString(),cnt);
                FoodCnt[sb.length()] = Math.max(FoodCnt[sb.length()],cnt );*/

                String str = sb.toString();
                int length = sb.length();

                if (!(FoodMap.get(length).containsKey(str))) {
                    FoodMap.get(length).put(str, 1);
                } else {
                    FoodMap.get(length).put(str, FoodMap.get(length).get(str)+1);
                    FoodCnt[length] = Math.max(FoodCnt[length], FoodMap.get(length).get(str));
                }
            }
            return;
        }
        combination(ch,pos+1,sb.append(ch[pos]));
        sb.deleteCharAt(sb.length()-1);
        combination(ch,pos+1,sb);
    }
}