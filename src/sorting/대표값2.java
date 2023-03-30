package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 대표값2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = new Integer[5];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println(sum / 5);

        Arrays.sort(arr);

        System.out.println(arr[2]);
    }
}
