package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀의귀재 {
    public static int count = 0;
    public static boolean recursion(String s, int l, int r) {
        count++;
        if (l >= r)
            return true;
        else if (s.charAt(l) != s.charAt(r))
            return false;
        else
            return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        if (recursion(s, 0, s.length() - 1))
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            count = 0;
            String s = br.readLine();
            System.out.println(isPalindrome(s) + " " + count);
        }
    }
}
