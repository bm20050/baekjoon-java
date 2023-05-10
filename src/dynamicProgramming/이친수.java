package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    public static long[] d;

    public static long dp(int n) {
        d[1] = 1;
        d[2] = 1;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d = new long[n + 1];

        if (n == 1)
            System.out.println(1);
        else
            System.out.println(dp(n));
    }
}
