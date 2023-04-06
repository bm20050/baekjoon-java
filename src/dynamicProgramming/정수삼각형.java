package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
    public static int[][] d;

    public static int dp(int[][] arr) {
        for (int i = 0; i < arr[arr.length - 1].length; i++) {
            d[arr.length - 1][i] = arr[arr.length - 1][i];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                d[i][j] = Math.max(d[i + 1][j], d[i + 1][j + 1]) + arr[i][j];
            }
        }
        return d[0][0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        d = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp(arr));
    }
}
