package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int[] temp = {Integer.parseInt(st.nextToken()), i};
            dq.offer(temp);
        }
        StringBuilder sb = new StringBuilder();

        int[] x = dq.pollFirst();
        int dir = x[0];
        sb.append(x[1]).append(" ");
        while (!dq.isEmpty()) {
            if (dir > 0) {
                for (int i = 0; i < dir - 1; i++)
                    dq.offerLast(dq.pollFirst());
                x = dq.pollFirst();
            } else if (dir < 0) {
                for (int i = 0; i < Math.abs(dir) - 1; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                x = dq.pollLast();
            }
            dir = x[0];
            sb.append(x[1]).append(" ");
        }

        System.out.println(sb);
    }
}
