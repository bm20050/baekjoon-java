package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < data.length; i++) {
            temp += data[i];
            sum += temp;
        }
        System.out.println(sum);
    }
}
