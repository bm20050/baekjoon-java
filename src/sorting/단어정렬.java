package sorting;

import java.util.*;

public class 단어정렬 {
    static class Compare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length())
                return -1;
            else if (o1.length() > o2.length())
                return 1;
            else {
                return o1.compareTo(o2);
            }
        }
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list;
        Compare c = new Compare();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        list = new ArrayList(set);

        Collections.sort(list, c);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
