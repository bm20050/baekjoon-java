package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static int[] d;

    public static int dp(int[][] arr, int n) {
        for (int i = 1; i <= n; i++) {
            int t = arr[i][0];
            int p = arr[i][1];

            if (i + t <= n + 1)
                d[i + t] = Math.max(d[i] + p, d[i + t]);

            d[i + 1] = Math.max(d[i + 1], d[i]);
        }
        return d[n + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][2];
        d = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(arr, n));
    }
}
