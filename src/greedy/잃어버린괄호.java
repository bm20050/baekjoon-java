package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sarr = s.split("[-]");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i].contains("+")) {
                int sum = 0;
                String[] temp = sarr[i].split("[+]");
                for (String ss : temp) {
                    sum += Integer.parseInt(ss);
                }
                list.add(sum);
            }
            else
                list.add(Integer.parseInt(sarr[i]));
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }

        System.out.println(result);
    }
}
