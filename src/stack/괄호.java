package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (temp == '(')
                    st.push(temp);
                else {
                    if (!st.isEmpty() && st.peek() == '(')
                        st.pop();
                    else
                        st.push(temp);
                }
            }
            if (st.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
