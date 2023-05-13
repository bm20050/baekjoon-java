package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {

    public static int[] d;

    public static int dp(int[] w, int[] v, int n, int k) {

        for (int i = 1; i <= n; i++) {
            for (int j = k; j - w[i] >= 0; j--) {
                d[j] = Math.max(d[j], d[j - w[i]] + v[i]);
            }
        }
        return d[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        d = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(dp(w, v, n, k));
    }
}
