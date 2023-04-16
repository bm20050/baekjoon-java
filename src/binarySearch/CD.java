package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CD {
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return 0;
        int mid = (start + end) / 2;

        if (arr[mid] == target)
            return 1;
        else if (arr[mid] < target)
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0)
                break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(br.readLine());
                count += binarySearch(arr, target, 0, n - 1);
            }
            System.out.println(count);
        }
    }
}
