import java.util.*;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class Mathematics {
    public static int Stirling(int n, int m) {
        if (n == m) return 1;
        if (m == 1) return 1;
        return Stirling(n - 1, m - 1) + m * Stirling(n - 1, m);
    }

    public static void main(String[] args) {
//        read();
//        Homeomorphism();
        functionMap();
    }


    //--------------Hamiltonian cycle
    static final int N = (int) 1e5;
    static final int M = (int) 1e6;
    static int n;
    static int m;
    static boolean flag = false;
    static ArrayList[] edge;

    static boolean[] mark = new boolean[N];
    static Deque cyc = new ArrayDeque();

    public void add(int x, int y) {
        edge[x].add(y);
        edge[y].add(x);
    }

    public Mathematics() {
        edge = new ArrayList[N];
    }

    public static void functionMap() {
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        int[] f = new int[N];
        for (int i = 0; i < N; ++i) {
            f[i] = S.nextInt();
        }

        //logic code and print
    }

    public static void read() {
        int x, y;
        Scanner S = new Scanner(System.in);
        n = S.nextInt();
        m = S.nextInt();
        for (int i = 1; i <= m; ++i) {
            x = S.nextInt();
            y = S.nextInt();
            edge[x].add(y);
            edge[y].add(x);
        }
    }

    public static void Hamitonian(int v, int ct) {
        if (ct == n) {
            flag = true;
            return;
        }
        if (flag) return;

        for (Object x : edge[v]) {
            int u = (int) x;
            if (mark[u]) continue;
            mark[u] = true;
            Hamitonian(u, ct + 1);
            mark[u] = false;
        }
    }

    public static void Homeomorphism() {
        for (int i = 1; i <= n; ++i) {
            if (edge[i].size() == 2) {
                int v1 = (int) edge[i].get(0);
                int v2 = (int) edge[i].get(1);
                edge[v1].remove(i);
                edge[v2].remove(i);
                edge[v1].add(v2);
                edge[v2].add(v1);
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (Object x : edge[i]) {
                int k = (int) x;
                if (k < i) continue;
                println(i, k);
            }
        }
    }


}
