import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        System.out.println(answer);
    }
}
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize ==0){
            answer = cities.length *5;
        }else {
            for (String city : cities) {
                String cityName = city.toLowerCase();
                if(!queue.contains(cityName)){
                    if(queue.size() < cacheSize) {
                        queue.add(cityName);
                    }else if(queue.size() ==cacheSize){
                        queue.poll();
                        queue.add(cityName);
                    }
                    answer +=5;
                }else if(queue.contains(cityName)){
                    queue.remove(cityName);
                    queue.add(cityName);
                    answer+=1;
                }
            }
        }
        return answer;
    }
}