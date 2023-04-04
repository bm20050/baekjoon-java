package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는함수실행 {
    public static int[][][] d = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && d[a][b][c] != 0)
            return d[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        else if (a > 20 || b > 20 || c > 20)
            return d[20][20][20] = w(20, 20, 20);
        else if (a < b && b < c)
            return d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else
            return d[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1)
                break;
            StringBuilder sb = new StringBuilder();
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c));

            System.out.println(sb);
        }
    }
}
