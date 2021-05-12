public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int answer = k.solution(new int[]{2,4,5,3,2,1,4,2,5,1},3);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] stones, int k) {
        //이분 탐색 사용
        int l =0;
        int r = 200000000;
        int mid =0;
        int answer =0;


        while(l<=r){
            mid = (l+r)/2;
            int[] temp = stones.clone();
            int count =0;
            boolean flag = false;

            for(int i=0; i< temp.length;i++){
                if(temp[i]<=mid){
                    temp[i]=0;
                    count +=1;
                    if(count==k){
                        flag = true;
                        break;
                    }
                }else{
                    count =0;
                }
            }

            if(flag){
                r = mid -1;
                answer = mid;
            }else{
                l = mid +1;
            }
        }
        return answer;
    }
}


//2번째 방법
// k개의 구간으로 나눠서 가장 큰 값이 지나갈수 있는 횟수이다
import java.util.Arrays;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;


        for(int i = 0; i<=stones.length-k; i++){
            int temp = i;
            int stone = stones[i];
            for(int j = i; j<i+k; j++){
                if(stones[j] > stone){
                    stone = stones[j];
                    temp = j;
                }
            }
            if(answer > stone){
                answer = stone;
            }
            i = temp;

        }
        return answer;
    }
}