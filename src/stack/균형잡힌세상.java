package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            if (s.equals("."))
                break;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[')
                    st.push(c);
                else if (!st.isEmpty() && c == ')' && st.peek() == '(')
                    st.pop();
                else if (!st.isEmpty() && c == ']' && st.peek() == '[')
                    st.pop();
                else if (c == ']' || c == ')')
                    st.push(c);
            }
            if (st.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
