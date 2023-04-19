package recursion;

import java.io.*;

public class 칸토어집합 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void cantor(String x) throws IOException {
        if (x.length() <= 1) {
            bw.write(x);
            return;
        }
        cantor(x.substring(0, x.length() / 3));
        cantor(" ".repeat(x.length() / 3));
        cantor(x.substring(0, x.length() / 3));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        while((s = br.readLine()) != null) {
            int x = (int) Math.pow(3, Integer.parseInt(s));
            cantor("-".repeat(x));
            bw.write("\n");
        }
        bw.close();
    }
}
