package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    public static long dp(long[] d, int n) {
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= n; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }
        return d[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long[] d = new long[101];
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(d, n));
        }
    }
}
