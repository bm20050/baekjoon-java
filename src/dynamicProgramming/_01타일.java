package dynamicProgramming;

import java.util.Scanner;

public class _01타일 {

    public static int[] d = new int[1000001];
    public static int dp(int n) {
        d[1] = 1;
        d[2] = 2;
        d[3] = 2;
        d[4] = 5;
        for (int i = 5; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 3]) % 15746;
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp(n));
    }
}
