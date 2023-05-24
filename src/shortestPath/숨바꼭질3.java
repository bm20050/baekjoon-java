package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
    static class Node implements Comparable<Node> {
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int[] arr = new int[100001];
    public static int n, k;

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        arr[n] = 0;
        pq.offer(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();

            int n1 = now + 1;
            if (n1 >= 0 && n1 < arr.length && arr[n1] > arr[now] + 1) {
                arr[n1] = arr[now] + 1;
                pq.offer(new Node(n1, 1));
            }

            int n2 = now - 1;
            if (n2 >= 0 && n2 < arr.length && arr[n2] > arr[now] + 1) {
                arr[n2] = arr[now] + 1;
                pq.offer(new Node(n2, 1));
            }

            int n3 = now * 2;
            if (n3 >= 0 && n3 < arr.length && arr[n3] > arr[now]) {
                arr[n3] = arr[now];
                pq.offer(new Node(n3, 0));
            }
        }
        return arr[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, Integer.MAX_VALUE);
        System.out.println(dijkstra());
    }
}
