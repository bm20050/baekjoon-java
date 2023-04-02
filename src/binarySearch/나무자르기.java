package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {

    public static int binarySearch(int[] arr, long target, int start, int end) {
        if (start > end)
            return end;

        int mid = (start + end) / 2;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid)
                sum += arr[i] - mid;
        }

        if (target <= sum)
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(arr, m, 1, arr[n - 1]));

    }
}
