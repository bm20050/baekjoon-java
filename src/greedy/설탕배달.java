package greedy;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            }
            else if (n >= 3) {
                n -= 3;
                count++;
            }
            else {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}
