import java.io.*;
import java.util.*;

public class solve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if(i==0){
                max[0] = min[0] = first;
                max[1] = min[1] = second;
                max[2] = min[2] = third;
            }else{
                int temp_first = max[0];
                int temp_second = max[1];
                int temp_third = max[2];
                max[0] = Math.max(temp_first,temp_second)+first;
                max[1] = Math.max( Math.max(temp_first,temp_second),temp_third) + second;
                max[2] = Math.max(temp_second,temp_third)+third;

                int temp_first2 = min[0];
                int temp_second2 = min[1];
                int temp_third2 = min[2];
                min[0] = Math.min(temp_first2,temp_second2)+first;
                min[1] = Math.min(Math.min(temp_first2,temp_second2),temp_third2)+second;
                min[2] = Math.min(temp_second2,temp_third2)+third;
            }
        }
        System.out.println(Math.max(Math.max(max[0],max[1]),max[2])+" "+Math.min(Math.min(min[0],min[1]),min[2]));

    }
}
