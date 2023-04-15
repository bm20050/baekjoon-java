package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x == 0) {
                if (pq.isEmpty())
                    sb.append(0 + "\n");
                else
                    sb.append(pq.poll()).append("\n");
            }
            else
                pq.offer(x);
        }
        System.out.println(sb);
    }
}
