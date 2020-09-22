public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        long ans =k.solution(25, new int[] {2,14,11,21,17},2);
        System.out.println(ans);
    }
}

class num6{
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 0;
        int end = distance;
        int mid =0;
        Arrays.sort(rocks);

        while(start <= end){
            mid = (start+end)/2; // 바위사이의 거리를 의미
            int removecnt =0;
            int prev =0;
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removecnt++;
                    if (removecnt > n) break;//해당 거리를 만족시키기 위해서는 n개 초과해서 바위를 제거해야하기 때무
                } else {
                    prev = rock;// 현재 바위를 기준으로 다음 바위부터 다시 시작
                }
            }
            if(removecnt>n) end =mid-1;
            else{
                answer = Math.max(answer, mid);
                start = mid +1;
            }
        }
        return answer;
    }