package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_binarySearch {

    public static int upperBound(int[] arr, int target, int start, int end) {
        if (start >= end)
            return start;

        int mid = (start + end) / 2;

        if (target < arr[mid])
            return upperBound(arr, target, start, mid);
        else
            return upperBound(arr, target, mid + 1, end);
    }

    public static int lowerBound(int[] arr, int target, int start, int end) {
        if (start >= end)
            return start;

        int mid = (start + end) / 2;

        if (target <= arr[mid])
            return lowerBound(arr, target, start, mid);
        else
            return lowerBound(arr, target, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, target, 0, n) - lowerBound(arr, target, 0, n)).append(" ");
        }
        System.out.println(sb);
    }
}
