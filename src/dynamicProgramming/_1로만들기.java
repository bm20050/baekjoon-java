package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기 {

    public static int[] d;

    public static int dp(int n) {
        for (int i = 1; i < d.length; i++)
            d[i] = d.length;


        d[1] = 0;
        d[2] = 1;
        d[3] = 1;

        for (int i = 1; i <= n; i++) {
            d[i + 1] = Math.min(d[i] + 1, d[i + 1]);
            d[i * 2] = Math.min(d[i] + 1, d[i * 2]);
            d[i * 3] = Math.min(d[i] + 1, d[i * 3]);
        }
        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[3 * (n + 1)];

        System.out.println(dp(n));
    }
}
