package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0 ;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (true) {
                if (left == i)
                    left++;
                else if (right == i)
                    right--;

                if (left >= right)
                    break;

                if (arr[left] + arr[right] > arr[i])
                    right--;
                else if (arr[left] + arr[right] < arr[i])
                    left++;
                else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
