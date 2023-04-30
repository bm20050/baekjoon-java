package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 1;
        int result = n + 1;
        int sum = 0;

        if (arr[i] >= m) {
            sum = arr[i];
            result = 1;
        } else {
            sum = arr[i] + arr[j];
        }

        while (i <= j && j < n) {
            if (sum >= m) {
                result = Math.min(result, j - i + 1);
                sum -= arr[i++];
            } else {
                if (j < n - 1) {
                    sum += arr[++j];
                } else
                    j++;
            }
        }

        if (result == n + 1)
            System.out.println(0);
        else
            System.out.println(result);
    }
}
