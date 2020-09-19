
//입국 심사
public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        long ans =k.solution(6, new int[] {7,10});
        System.out.println(ans);
    }
}

class num6{
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min =1;
        long max = times[times.length-1] * n;

        long answer = max;
        while(min<=max){
            long  sum =0;
            long  mid = (max+min)/2;
            for(int time : times){
                sum += mid/time;
            }
            if(sum>=n){
                if(mid<answer){
                    answer=mid;

                }
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return answer;
    }
}