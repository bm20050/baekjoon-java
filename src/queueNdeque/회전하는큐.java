package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            int x = q.indexOf(arr[i]);
            int mid = q.size() / 2;

            if (x <= mid) {
                for (int j = 0; j < x; j++) {
                    int temp = q.pollFirst();
                    q.offerLast(temp);
                    count++;
                }
            }
            else {
                for (int j = 0; j < q.size() - x; j++) {
                    int temp = q.pollLast();
                    q.offerFirst(temp);
                    count++;
                }
            }
            q.pollFirst();
        }
        System.out.println(count);
    }
}
