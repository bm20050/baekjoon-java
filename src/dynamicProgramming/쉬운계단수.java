package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운계단수 {

    public static long[][] d;
    public static long mod = 1000000000L;

    public static long dp(int n) {
        Arrays.fill(d[1], 1);

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                if (j == 9)
                    d[i][9] = d[i - 1][8] % mod;
                else
                    d[i][j] = (d[i - 1][j - 1] % mod + d[i - 1][j + 1] % mod) % mod;
            }
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result = (result + d[n][i]) % mod;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new long[n + 1][10];

        System.out.println(dp(n));
    }
}
