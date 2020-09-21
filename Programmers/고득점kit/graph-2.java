
//순위
public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        long ans =k.solution(5, new int[][] {{4,3},{4,2},{3,2},{1,2},{2,5}});
        System.out.println(ans);
    }
}
//플루이드 워샬 알고리즘
class num6{
    public int solution(int n, int[][] results) {
        int answer = 0;
        int max = 1000000;
        int[][] chk = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                chk[i][j]=max;
            }
        }
        for(int[] a : results){
            chk[a[0]][a[1]] = 1;
        }

        for(int k=1; k<n+1;k++){//거치는 노드
            for(int j=1;j<n+1;j++){//출발 노드
                for(int l=1; l<n+1;l++){//도착 노드
                    if(chk[j][l]>chk[j][k]+chk[k][l]){
                        chk[j][l]=chk[j][k]+chk[k][l];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(chk));

        for(int i=1; i<n+1;i++){
            boolean check =true;
            for(int k =1; k<n+1;k++){
                if(i==k) continue;
                if(chk[i][k]==max && chk[k][i] == max){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}

