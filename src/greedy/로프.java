package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(arr[i] * (n - i), result);
        }
        System.out.println(result);
    }
}
