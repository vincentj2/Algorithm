public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String answer = k.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
        System.out.println(answer);
    }
}
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play_time_sec = makeSec(play_time);
        int adv_time_sec  = makeSec(adv_time);
        long[] total_sec = new long[play_time_sec+1];

        for (String log : logs) {
            total_sec[makeSec(log.substring(0, 8))] += 1;
            total_sec[makeSec(log.substring(9))] -= 1;
        }
        ///동시 재생자 수
        for(int i=1; i<total_sec.length;i++){
            total_sec[i] += total_sec[i-1];
        }
        //누적 재생자 수
        for(int i=1; i<total_sec.length;i++){
            total_sec[i] += total_sec[i-1];
        }
        long min_start =0L;
        long max = total_sec[adv_time_sec-1];
        for(int i=0; i<=play_time_sec-adv_time_sec;i++){
            long temp = total_sec[i+adv_time_sec] - total_sec[i];
            if(temp>max){
                max = temp;
                min_start = (long) i+1;
            }
        }
        int min_time = (int) min_start;
        int hour = min_time/3600;
        int time = min_time%3600;
        int minute = time/60;
        int sec = time%60;

        String h = (hour>9) ? Integer.toString(hour) : "0"+ hour;
        String m = (minute>9) ? Integer.toString(minute) : "0"+ minute;
        String s = (sec>9) ? Integer.toString(sec) : "0"+ sec;

        answer = h+":"+m+":"+s;
        return answer;
    }

    static int makeSec(String time){
        return Integer.parseInt(time.substring(0,2))*3600+  Integer.parseInt(time.substring(3,5))*60+ Integer.parseInt(time.substring(6));
    }
}