package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {

    public static int[] d;

    public static int dp(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + arr[j]);
            }
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d = new int[n + 1];
        System.out.println(dp(arr, n));
    }
}
