import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solve {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int drawNumber = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];
        for (int[] m : map) Arrays.fill(m, -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = x1 + 1;
            map[y][x1] = drawNumber;
            map[y][x2] = drawNumber;
            drawNumber++;
        }

        for (int i = 0; i <= 3; i++)
            if (dfs(1, 0, i)) break;
        System.out.println(answer > 3 ? -1 : answer);
    }

    static boolean dfs(int y, int addLine, int size) {
        if (addLine == size) {
            if (check()) {
                answer = addLine;
                return true;
            }
            return false;
        }

        for (int i = y; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                int current = map[i][j];
                int next = map[i][j + 1];
                if (current != -1 || next != -1) continue;
                addLine(i, j);
                if (dfs(i, addLine + 1, size)) return true;
                removeLine(i, j);
            }
        }
        return false;
    }

    static void addLine(int y, int x) {
        drawNumber++;
        map[y][x] = drawNumber;
        map[y][x + 1] = drawNumber;
    }

    static void removeLine(int y, int x) {
        map[y][x] = -1;
        map[y][x + 1] = -1;
    }

    static boolean check() {
        for (int x = 1; x <= N; x++) {
            int cursor = x;
            for (int y = 1; y <= H; y++) {
                int current = map[y][cursor];
                if (current != -1) {
                    //왼쪽으로 이동
                    if (cursor - 1 >= 1 && map[y][cursor - 1] == current) {
                        cursor = cursor - 1;
                    }//오른쪽으로 이동
                    else if (cursor + 1 <= N && map[y][cursor + 1] == current) {
                        cursor = cursor + 1;
                    }
                }
            }
            if (cursor != x) {
                return false;
            }
        }
        return true;
    }
}