package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            Integer[] arr = new Integer[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                q.offer(v);
                arr[j] = v;
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int count = 0;
            int y = 0;
            while (!q.isEmpty()) {
                int x = q.poll();
                if (x < arr[y]) {
                    q.offer(x);
                    if (m == 0)
                        m = q.size() - 1;
                    else
                        m--;
                }
                else {
                    count++;
                    if (arr[y] == x && m == 0)
                        break;
                    y++;
                    m--;
                }
            }
            System.out.println(count);

        }
    }
}
