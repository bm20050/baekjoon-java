package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return end;

        int mid = (start + end) / 2;
        int sum = 0;
        for (int j : arr) {
            sum += Math.min(j, mid);
        }

        if (sum <= target) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }
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
        int target = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(arr, target, 0, arr[n - 1]));
    }
}
