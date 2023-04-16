package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕 {
    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return false;

        int mid = (start + end) / 2;

        if (arr[mid] == target)
            return true;
        else if (arr[mid] < target)
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int target = Integer.parseInt(st.nextToken());
                if (binarySearch(arr, target, 0, n - 1))
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            }
        }
        bw.close();
    }
}
