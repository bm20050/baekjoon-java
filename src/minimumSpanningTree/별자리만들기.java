package minimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 별자리만들기 {
    static class Node {
        private float x;
        private float y;

        public Node(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }

    static class Edge implements Comparable<Edge> {
        private float distance;
        private int nodeA;
        private int nodeB;

        public Edge(float distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public float getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        @Override
        public boolean equals (Object o) {
            Edge e = (Edge) o;
            if (this.distance == e.distance && ((this.nodeA == e.nodeA && this.nodeB == e.nodeB) || (this.nodeA == e.nodeB && this.nodeB == e.nodeA)))
                return true;
            return false;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.distance - o.distance);
        }
    }

    public static int n;
    public static int[] parent;
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static float result = 0;

    public static int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            nodes.add(new Node(x, y));
        }

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if (i != j) {
                    float x2 = (float) Math.pow(nodes.get(i).getX() - nodes.get(j).getX(), 2);
                    float y2 = (float) Math.pow(nodes.get(i).getY() - nodes.get(j).getY(), 2);
                    float dist = (float) Math.sqrt(x2 + y2);
                    Edge newEdge = new Edge(dist, i, j);
                    if (!edges.contains(newEdge))
                        edges.add(newEdge);
                }
            }
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            float cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }
}
