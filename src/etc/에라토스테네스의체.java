package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (arr[j]) {
                    arr[j] = false;
                    k--;
                    if (k == 0) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }


    }
}
