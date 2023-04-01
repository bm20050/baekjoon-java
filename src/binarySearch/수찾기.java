package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {

    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return false;

        int mid = (start + end) / 2;

        if (target == arr[mid])
            return true;
        else if (target < arr[mid])
            return binarySearch(arr, target, start, mid - 1);
        else
            return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
           int target = Integer.parseInt(st.nextToken());
           if (binarySearch(arr, target, 0, n - 1))
               bw.write(1 + "\n");
           else
               bw.write(0 + "\n");
        }
        bw.close();
    }
}
