package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {

    public static int[] d;

    public static int dp(int[] arr) {
        d[1] = arr[1];
        if (arr.length > 2) {
            d[2] = arr[1] + arr[2];
        }
        for (int i = 3; i < arr.length; i++) {
            d[i] = Math.max(d[i - 1], Math.max(d[i - 2] + arr[i], d[i - 3] + arr[i - 1] + arr[i]));
        }
        return d[arr.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(arr));
    }
}
