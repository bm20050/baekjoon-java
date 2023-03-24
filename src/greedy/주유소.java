package greedy;

import java.util.Scanner;

public class 주유소 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] len = new int[n - 1];
        int[] liter = new int[n];
        for (int i = 0; i < n - 1; i++) {
            len[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            liter[i] = sc.nextInt();
        }
        int price = 1000000000;
        int result = 0;
        for (int i = 0; i < len.length; i++) {
            if (liter[i] < price)
                price = liter[i];
            result += price * len[i];
        }
        System.out.println(result);
    }
}
