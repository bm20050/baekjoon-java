package bruteforce;

import java.util.Scanner;

public class _2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x = x / 10;
            }
            if (i + sum == n) {
                System.out.println(i);
                break;
            }
        }
    }
}
