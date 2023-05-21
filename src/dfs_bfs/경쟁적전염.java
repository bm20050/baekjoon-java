package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경쟁적전염 {
    public static int[][] ans;
    public static int k;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void bfs(int[][] arr, int ix, int iy) {
        ans[ix][iy] = arr[ix][iy];
        for (int i = 0; i < 4; i++) {
            int nx = ix + dx[i];
            int ny = iy + dy[i];
            arr[nx][ny] = k;
            if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[nx].length)
                continue;

            if (ans[nx][ny] == k)
                ans[nx][ny] = Math.min(ans[nx][ny], arr[ix][iy]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int a = 0; a < s; a++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != 0) {
                        bfs(arr, i, j);
                    }
                }
            }
            arr = ans;
        }
        if (ans[x - 1][y - 1] == k)
            System.out.println(0);
        else
            System.out.println(ans[x - 1][y - 1]);
    }
}
