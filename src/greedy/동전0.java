package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (data[i] <= k) {
                count += k / data[i];
                k %= data[i];
            }
        }
        System.out.println(count);
    }
}