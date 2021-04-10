import java.util.*;
// 플로이드 워셜 알고리즘 사용
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];
        int min = 200*100000+1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) distance[i][j] = 0;
                else{
                    distance[i][j] = min;
                }
            }
        }

        for(int[] fare : fares){
            distance[fare[0]-1][fare[1]-1] = fare[2];
            distance[fare[1]-1][fare[0]-1] = fare[2];
        }


        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                for(int l=0; l<n;l++){
                    if(distance[k][i]==0 || distance[i][l]==0) continue;
                    else if(distance[k][l] > distance[k][i] + distance[i][l]){
                        distance[k][l] = distance[k][i] + distance[i][l];
                    }
                }
            }
        }

        for(int temp =0; temp<n; temp++){
            answer = Math.min(answer,distance[s-1][temp] + distance[temp][a-1] + distance[temp][b-1]);
        }
        return answer;
    }
}