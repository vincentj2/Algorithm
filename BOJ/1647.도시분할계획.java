import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class Edge implements Comparable{
    int src, dst, cost;
    public Edge(int src, int dst, int cost) {
        this.src = src;
        this.dst = dst;
        this.cost = cost;
    }
    @Override
    public int compareTo(Object o) {
        return this.cost - ((Edge)o).cost;
    }
}
public class Main {
    static int n, m, parent[];
    static List<Edge> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.add(new Edge(s, d, c));
        }
        Collections.sort(adj);

        int ans = 0, last = 0;
        for (int i = 0; i < adj.size(); i++) {
            Edge here = adj.get(i);
            int u = here.src, v = here.dst, cost = here.cost;
            u = find(u); v = find(v);
            if(u == v) continue;
            union(u, v);
            ans += cost;
            last = cost;
        }
        System.out.println(ans - last);
    }

    private static void solution() {
        int ans = 0, last = 0;
        for (int i = 0; i < adj.size(); i++) {
            Edge here = adj.get(i);
            int u = here.src, v = here.dst, cost = here.cost;
            u = find(u); v = find(v);
            if(u == v) continue;
            union(u, v);
            ans += cost;
            last = cost;
        }
        System.out.println(ans - last);
    }

    private static void union(int u, int v) {
        u = find(u); v = find(v);
        if(u == v) return;
        if(u > v){
            int temp = u;
            u = v;
            v = temp;
        }
        parent[v] = u;
    }
    private static int find(int v) {
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}