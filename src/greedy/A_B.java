package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        while (b > a) {
            if (b % 10 == 1) {
                b = (b - 1) / 10;
                count++;
            } else if (b % 2 == 0) {
                b /= 2;
                count++;
            } else
                break;
        }
        if (b == a)
            System.out.println(count + 1);
        else
            System.out.println(-1);
    }
}
