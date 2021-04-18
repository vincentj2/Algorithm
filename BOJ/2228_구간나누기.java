import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve {
    static int ans;
    static int N;
    static int M;
    static int[] num;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(ans);
    }
}