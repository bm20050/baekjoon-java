package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int temp = 1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (st.isEmpty()) {
                while (temp <= x) {
                    st.push(temp++);
                    sb.append("+\n");
                }
            }
            if (st.peek() > x){
                flag = false;
                break;
            }

            if (st.peek() < x) {
                while (temp <= x){
                    st.push(temp++);
                    sb.append("+\n");
                }
            }

            st.pop();
            sb.append("-\n");
        }
        if (flag)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
