package binarySearch;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2_hashmap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (map.get(x) != null){
                int temp = map.get(x);
                map.put(x, temp + 1);
            }
            else
                map.put(x, 1);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (map.get(x) != null)
                bw.write(map.get(x) + " ");
            else
                bw.write(0 + " ");
        }
        bw.close();
    }
}
