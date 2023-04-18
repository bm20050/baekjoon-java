package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {
    public static int count = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void hanoi(int n, int from, int temp, int to) {
        if (n == 0)
            return;
        count++;
        hanoi(n - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);
        sb.insert(0, count + "\n");

        System.out.println(sb);
    }
}
