package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {
    static class Node {
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
    }

    public static int[][] ans;

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static boolean[][] visited;

    public static void bfs(int[][] arr, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[nx].length)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (arr[nx][ny] == 0)
                    arr[nx][ny] = arr[x][y] + 1;
                else
                    arr[nx][ny] = Math.min(arr[nx][ny], arr[x][y] + 1);

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    visited = new boolean[n][m];
                    bfs(arr, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max - 1);
    }
}
