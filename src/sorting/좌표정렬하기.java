package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬하기 {
    static class Node implements Comparable<Node> {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x < o.x)
                return -1;
            else if (this.x > o.x)
                return 1;
            else {
                if (this.y < o.y)
                    return -1;
                else
                    return 1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Node(x, y));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            System.out.println(node.getX() + " " + node.getY());
        }
    }
}
