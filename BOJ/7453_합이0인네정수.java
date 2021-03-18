import java.util.*;

public class solve {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A= new int[n];
        int[] B= new int[n];
        int[] C= new int[n];
        int[] D= new int[n];
        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        long answer =0;

        for(int j=0; j<n ;j++) {
            A[j] = sc.nextInt();
            B[j] = sc.nextInt();
            C[j] = sc.nextInt();
            D[j] = sc.nextInt();
        }
        int idx =0;
        for(int i=0;i<n;i++){
            for(int j=0; j<n ;j++){
                AB[idx] = A[i]+B[j];
                CD[idx] = C[i]+D[j];
                idx++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int start = 0;
        int end = idx-1;

        while(start<AB.length && end >=0 ){
            int ab = AB[start];
            int cd = CD[end];
            int sum = ab+cd;

            if(sum ==0){
                //중복 체크
                int ab_cnt =0;
                int temp = start;
                while(ab== AB[temp] ){
                    start++;
                    ab_cnt++;
                    temp++;
                    if(temp >= AB.length) break;
                }
                int cd_cnt =0;
                temp =end;
                while (cd == CD[temp]){
                    temp--;
                    end--;
                    cd_cnt++;
                    if(temp<0) break;
                }
                answer += (long)ab_cnt * (long)cd_cnt;
            }
            else if(sum <0){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.println(answer);
    }
}