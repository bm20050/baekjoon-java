package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("push_front")) {
                int x = Integer.parseInt(s.split(" ")[1]);
                q.addFirst(x);
            } else if (s.contains("push_back")) {
                int x = Integer.parseInt(s.split(" ")[1]);
                q.addLast(x);
            } else if (s.equals("pop_front")) {
                if (q.size() != 0)
                    sb.append(q.pollFirst()).append("\n");
                else
                    sb.append(-1 + "\n");
            } else if (s.equals("pop_back")) {
                if (q.size() != 0)
                    sb.append(q.pollLast()).append("\n");
                else
                    sb.append(-1 + "\n");
            } else if (s.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (s.equals("empty")) {
                if (q.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            } else if (s.equals("front")) {
                if (q.size() != 0)
                    sb.append(q.getFirst()).append("\n");
                else
                    sb.append(-1 + "\n");
            } else if (s.equals("back")) {
                if (q.size() != 0)
                    sb.append(q.getLast()).append("\n");
                else
                    sb.append(-1 + "\n");
            }
        }
        System.out.println(sb);
    }
}
