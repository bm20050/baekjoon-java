package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    public static long[] d = new long[100001];

    public static long dp(int[] arr) {
        long max = arr[0];
        d[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            d[i] = Math.max(arr[i] + d[i - 1], arr[i]);

            max = Math.max(max, d[i]);

        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(arr));
    }
}
