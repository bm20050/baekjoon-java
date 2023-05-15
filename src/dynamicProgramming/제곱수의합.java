package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int x = d[i - j * j] + 1;
                if (d[i] > x) {
                    d[i] = x;
                }
            }
        }
        System.out.println(d[n]);
    }
}
