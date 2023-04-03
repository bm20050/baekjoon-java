package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알고리즘수업_피보나치수1 {

    public static int cnt1 = 0;
    public static int cnt2 = 0;
    public static int[] f = new int[41];

    public static int fib(int n) {
        if (n <= 2) {
            cnt1++;
            return 1;
        }
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt1);
        sb.append(" ");
        sb.append(cnt2);

        System.out.println(sb);
    }
}
