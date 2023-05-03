package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임 {

    public static int binarySearch(int z, int y, int x) {
        int ans = -1;
        int start = 0;
        int end = (int) 1e9;

        while (start <= end) {
            int mid = (start + end) / 2;

            if ((int) ((long) (y + mid) * 100 /(x + mid)) != z) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = (int) ((long) y * 100 / x);

        System.out.println(binarySearch(z, y, x));
    }
}
