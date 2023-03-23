package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        Arrays.sort(data, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        Arrays.sort(data, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int x = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] >= x) {
                x = data[i][1];
                count += 1;
            }
        }
        System.out.println(count);
    }
}
