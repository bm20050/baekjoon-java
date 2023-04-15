package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("push")) {
                int x = Integer.parseInt(s.split(" ")[1]);
                q.offer(x);
            } else if (s.equals("pop")) {
                if (q.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(q.poll()).append("\n");
            } else if (s.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (s.equals("empty")) {
                if (q.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            } else if (s.equals("front")) {
                if (q.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(q.getFirst()).append("\n");
            } else if (s.equals("back")) {
                if(q.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(q.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
