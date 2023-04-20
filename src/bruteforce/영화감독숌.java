package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 665;
        String s = "";
        int i = 0;
        while (i != n) {
            s = String.valueOf(++x);
            if (s.contains("666"))
                i++;
        }
        System.out.println(s);
    }
}
