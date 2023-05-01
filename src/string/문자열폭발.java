package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        String s = br.readLine();
        String t = br.readLine();
        StringBuffer sbb = new StringBuffer(t);
        String target = sbb.reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            if (st.size() >= target.length() && st.peek().equals(target.charAt(0))) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < target.length(); j++) {
                    sb.append(st.pop());
                }
                if (!target.equals(sb.toString())) {
                    for (int j = sb.length() - 1; j >= 0; j--) {
                        st.push(sb.charAt(j));
                    }
                }
            }
        }
        if (st.isEmpty())
            System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sbb = new StringBuffer(sb);
            System.out.println(sbb.reverse().toString());
        }
    }
}
