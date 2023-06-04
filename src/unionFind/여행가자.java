package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {

    public static int[] parent;

    public static int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    unionParent(i, j);
                }
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int start = findParent(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (start != findParent(now)) {
                flag = false;
            }
        }

        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
