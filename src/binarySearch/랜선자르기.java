package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {

    public static long binarySearch(long[] len, int n, long start, long end) {
        if (start > end)
            return end;

        long mid = (start + end) / 2;

        int count = 0;
        for (int i = 0; i < len.length; i++) {
            count += len[i] / mid;
        }

        if (count < n)
            return binarySearch(len, n, start, mid - 1);
        else
            return binarySearch(len, n, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] len = new long[k];

        for (int i = 0; i < k; i++) {
            len[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(len);

        System.out.println(binarySearch(len, n, 1, len[k - 1]));

    }
}
