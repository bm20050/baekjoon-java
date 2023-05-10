package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
    public static int[][] d;
    public static void dp() {
        for (int i = 0; i < 30; i++) {
            d[i][i] = 1;
            d[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        d = new int[30][30];
        dp();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(d[m][n]);
        }
    }
}
