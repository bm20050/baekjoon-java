package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static final int INF = (int) 2e9;
    public static int n, e, u, v;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d;

    public static int dijkstra(int start, int end) {
        d = new int[n + 1];
        Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[idx]) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }

        return d[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, n);

        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, n);

        if (ans1 >= INF && ans2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(ans1, ans2));
    }
}
