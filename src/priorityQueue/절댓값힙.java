package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (Math.abs(o1) - Math.abs(o2) < 0)
                    return -1;
                else if (Math.abs(o1) - Math.abs(o2) > 0)
                    return 1;
                else {
                    return (int) (o1 - o2);
                }
            }
        });
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
            else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}
