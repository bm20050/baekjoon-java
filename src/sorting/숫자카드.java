package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {

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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ncards = new int[n];
        for (int i = 0; i < n; i++) {
            ncards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ncards);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mcards = new int[m];
        for (int i = 0; i < m; i++) {
            mcards[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = ncards.length - 1;
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(ncards, mcards[i], start, end) + " ");
        }
    }
}
