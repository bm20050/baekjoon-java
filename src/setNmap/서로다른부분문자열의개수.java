package setNmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            String ss = "";
            for (int j = i; j < s.length(); j++) {
                ss += s.substring(j, j + 1);
                set.add(ss);
            }
        }

        System.out.println(set.size());
    }
}
