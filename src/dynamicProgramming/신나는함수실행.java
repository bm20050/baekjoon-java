package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는함수실행 {

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20)
            return w(20, 20, 20);
        else if (a < b && b < c)
            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else
            return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        while (a != -1 && b != -1 && c != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("w(");
            sb.append(a);
            sb.append(", ");
            sb.append(b);
            sb.append(", ");
            sb.append(c);
            sb.append(") = ");
            sb.append(w(a, b, c));

            System.out.println(sb);

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
