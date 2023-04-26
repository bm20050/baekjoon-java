package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_10 {

    public static void star(String x, int n) {
        if (x.length() <= 1) {
            System.out.println(x);
            return;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        star("*".repeat(n), n / (n / 3));
    }
}
