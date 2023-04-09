package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);

        int v = 0;
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(b[i])) {
                map.put(b[i], v++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(map.get(a[i]) + " ");
        }

        System.out.println(sb);
    }
}
