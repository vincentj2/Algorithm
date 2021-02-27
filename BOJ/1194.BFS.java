import java.util.*;

/*
268ms 20904KB
BFS, 비트마스크 사용
일반적인 BFS의 방문 체크와 달리 특수한 경우에 따른 방문 체크가 필요하다.
3차원 배열을 선언하여 마지막 부분이 보유한 key의 상태를 이진수로 할당하여 각 상황을 판단
 */
public class solve {
    static int[] row_pos = new int[]{-1,0,0, 1};
    static int[] col_pos = new int[]{0, 1,-1, 0};
    static int N ,M;
    static char[][] map;
    static int [][][] visit;

    static Queue<int[]> queue;

    public static void main(String[] args){
        // 입출력 처리 //
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visit = new int[N][M][64];

        for(int i=0; i<N; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        // 입출력 처리 끝 //
        queue = new LinkedList<>();
        for(int i=0; i<N ; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='0'){
                    queue.add(new int[] {i ,j,0});
                    visit[i][j][0] =1;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(BFS());
    }

    static int BFS(){
        int time =0;

        while(!queue.isEmpty()){
            int size = queue.size();
            time++;

            for(int idx =0 ;idx<size ;idx++) {
                int[] temp = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int row = temp[0] + row_pos[i];
                    int col = temp[1] + col_pos[i];
                    int key = temp[2];

                    if (row < 0 || row >= N || col < 0 || col >= M || visit[row][col][temp[2]] ==1 || map[row][col] == '#') {
                        continue;
                    }

                    if (map[row][col] == '1') return time;

                        //문인 경우
                    else if (map[row][col] >= 'A' && map[row][col] <= 'F') {
                        int cd = 1 << (map[row][col] - 'A');
                        if((temp[2] & cd) != cd) continue;
                    }
                    //키인 경우
                    else if (map[row][col] >= 'a' && map[row][col] <= 'f') {
                        int ck = 1 << (map[row][col] - 'a');
                        if((temp[2] & ck) != ck){
                            key |= ck;
                        }
                    }
                    queue.add(new int[] {row,col,key});
                    visit[row][col][temp[2]] =1 ;
                }
            }
        }
        return -1;
    }
}