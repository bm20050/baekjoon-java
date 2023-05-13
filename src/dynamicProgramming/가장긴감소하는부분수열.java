package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {

    public static int[] d;

    public static int dp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }
        int max = 1;
        for (int i = 0; i < d.length; i++) {
            max = Math.max(max, d[i]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(arr));
    }
}
