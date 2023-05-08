package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {

    public static int[] zero;
    public static int[] one;

    public static void dp(int n) {
        zero[0] = 1;
        zero[1] = 0;
        zero[2] = 1;

        one[0] = 0;
        one[1] = 1;
        one[2] = 1;

        for (int i = 3; i <= n; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        zero = new int[41];
        one = new int[41];
        dp(40);

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(zero[n] + " " + one[n]);
        }
    }
}
