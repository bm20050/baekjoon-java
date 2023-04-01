package greedy;

import java.util.Scanner;

public class 주유소 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] len = new long[n - 1];
        long[] liter = new long[n];
        for (int i = 0; i < n - 1; i++) {
            len[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            liter[i] = sc.nextInt();
        }
        long price = 1000000000;
        long result = 0;
        for (int i = 0; i < len.length; i++) {
            if (liter[i] < price)
                price = liter[i];
            result += price * len[i];
        }
        System.out.println(result);
    }
}
