package setNmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(s, i);
            map2.put(i, s);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    flag = false;
                    System.out.println(map2.get(Integer.parseInt(s)));
                    break;
                }
            }

            if (flag) {
                System.out.println(map.get(s));
            }
        }
    }
}
